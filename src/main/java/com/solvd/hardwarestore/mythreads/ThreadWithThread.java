package com.solvd.hardwarestore.mythreads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadWithThread extends Thread{
    private static final Logger LOGGER = LogManager.getLogger(ThreadWithThread .class);
    public void run(){
        LOGGER.info("Hello with thread");
    }
}
