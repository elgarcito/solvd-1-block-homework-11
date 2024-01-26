package com.solvd.hardwarestore.mythreads;

import com.solvd.hardwarestore.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadWithRunnable implements Runnable{
    private static final Logger LOGGER = LogManager.getLogger(ThreadWithRunnable.class);
    @Override
    public void run(){
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("Hello with runnable");
    }
}
