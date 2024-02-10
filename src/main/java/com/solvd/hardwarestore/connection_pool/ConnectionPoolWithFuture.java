package com.solvd.hardwarestore.connection_pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionPoolWithFuture {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPoolWithFuture.class);
    private final ArrayList<MockConnection> connectionList;
    private ArrayList<MockConnection> usedConnectionList=new ArrayList<>();
    private static volatile ConnectionPoolWithFuture instanceOfConnectionPool;
    private static final int POOl_SIZE=5;
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    //creating a private constructor to start the conection pool.
    private ConnectionPoolWithFuture(){
        connectionList=new ArrayList<>(POOl_SIZE);
        for (int i = 0; i < POOl_SIZE; i++) {
            connectionList.add(MockConnection.createMockConnection());
        }
    }

    //Using singleton pattern
    public synchronized static ConnectionPoolWithFuture getInstance(){
      if(instanceOfConnectionPool==null){
          instanceOfConnectionPool=new ConnectionPoolWithFuture();
      }
      return instanceOfConnectionPool;
    };

    public CompletionStage<MockConnection> getConnectionCompletionStage() {

        CompletableFuture<MockConnection> futureResponse=new CompletableFuture<>();
        executorService.submit(()-> {
            MockConnection mockConnectionToRelease = connectionList.remove(connectionList.size() - 1);
            connectionList.remove(mockConnectionToRelease);
            usedConnectionList.add(mockConnectionToRelease);
            futureResponse.complete(mockConnectionToRelease);
        });
        return futureResponse;
    }

    public void releaseConnection(MockConnection mockConnection){
        usedConnectionList.remove(mockConnection);
        connectionList.add(mockConnection);
    }

    public void shutDownExecutorService() {
        executorService.shutdown();
    }
}
