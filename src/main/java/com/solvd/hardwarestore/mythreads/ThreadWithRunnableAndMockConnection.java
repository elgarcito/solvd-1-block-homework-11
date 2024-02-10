package com.solvd.hardwarestore.mythreads;

import com.solvd.hardwarestore.connection_pool.ConnectionPool;
import com.solvd.hardwarestore.connection_pool.MockConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadWithRunnableAndMockConnection implements Runnable{
    private static final Logger LOGGER = LogManager.getLogger(ThreadWithRunnableAndMockConnection.class);
    private ConnectionPool connectionPool;

    public ThreadWithRunnableAndMockConnection(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void run(){
        MockConnection mockConnection= null;
        try {

            mockConnection = connectionPool.getConnection();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("mock connection from thread: "+Thread.currentThread().getName()+" is connected "+ mockConnection.hashCode());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        connectionPool.releaseConnection(mockConnection);
        LOGGER.info(Thread.currentThread().getName()+ " is released: "+mockConnection.hashCode());
    }
}
