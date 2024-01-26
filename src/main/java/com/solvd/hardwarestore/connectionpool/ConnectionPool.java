package com.solvd.hardwarestore.connectionpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private final ArrayList<MockConnection> connectionList;
    private ArrayList<MockConnection> usedConnectionList=new ArrayList<>();
    private static volatile ConnectionPool instanceOfConnectionPool;
    private static final int POOl_SIZE=5;

    //creating a private constructor to start the conection pool.
    private ConnectionPool(){
        connectionList=new ArrayList<>(POOl_SIZE);
        for (int i = 0; i < POOl_SIZE; i++) {
            connectionList.add(MockConnection.createMockConnection());
        }
    }

    //Using singleton pattern
    public synchronized static ConnectionPool getInstance(){
      if(instanceOfConnectionPool==null){
          instanceOfConnectionPool=new ConnectionPool();
      }
      return instanceOfConnectionPool;
    };

    public synchronized MockConnection getConnection() throws InterruptedException {
        if (this.connectionList.isEmpty()){
                LOGGER.info(Thread.currentThread().getName() +" waiting for connection");
                doWait();
        }
        MockConnection mockConnectionToRelease=connectionList.remove(connectionList.size()-1);
        connectionList.remove(mockConnectionToRelease);
        usedConnectionList.add(mockConnectionToRelease);
        return mockConnectionToRelease;
    };

    public void releaseConnection(MockConnection mockConnection){
        usedConnectionList.remove(mockConnection);
        connectionList.add(mockConnection);
        doNotify();
    }

//    public synchronized void notifyBlock() {
//         lock.notifyAll();
//    }

    public synchronized void doWait() {
        try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void doNotify() {
        notifyAll();
    }

}
