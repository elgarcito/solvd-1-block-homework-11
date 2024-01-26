package com.solvd.hardwarestore.connectionpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MockConnection {
    private static final Logger LOGGER = LogManager.getLogger(MockConnection.class);
    public static MockConnection createMockConnection(){
        return new MockConnection();
    }

}
