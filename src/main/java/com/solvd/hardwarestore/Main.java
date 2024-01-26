package com.solvd.hardwarestore;
/*
Hardware store
In this project, we have a hardware store that sells different products.
We represent this product using classes.
Now we can se the classes and some examples of the kind of product that they are going to content:
1-ConstructionProduct: nails, screws, cement, sand etc. we sell it by it units, for ex.
10 kg of sand
2-ElectricProduct: cables, electric tape, socket outlet,power drills, hole puncher, etc.
3-HandTool: hammer, hand saw
4-GardenProduct:shovel, plant pot
5-HouseholdItem: kettle, broom, brush
6-WaterProduct:water filter, water pump
7-GasProduct: gas valve,etc

Also, we have:
Employee: the employee of the store.
ProductSupplier: the one that sells the product.
Client: the one that buys the product.
 */
import com.solvd.hardwarestore.connectionpool.ConnectionPool;
import com.solvd.hardwarestore.connectionpool.MockConnection;
import com.solvd.hardwarestore.mythreads.ThreadWithRunnable;
import com.solvd.hardwarestore.mythreads.ThreadWithRunnableAndMockConnection;
import com.solvd.hardwarestore.mythreads.ThreadWithThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Main {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        //Two threads creation
        LOGGER.info("Hello from main");
        //Thread with runnable
        ThreadWithRunnable threadWithRunnable = new ThreadWithRunnable();
        (new Thread(threadWithRunnable)).start();
        //Thread with extends of Thread
        (new ThreadWithThread()).start();
        LOGGER.info("Bye from main");
        System.out.println();

        //Connection pool Example
        ConnectionPool connectionPool=ConnectionPool.getInstance();
        int amountOfConnections=7;
        ArrayList<Thread> listOfThreads=new ArrayList<>();
        for (int i = 0; i < amountOfConnections; i++) {
            Thread thread=new Thread(new ThreadWithRunnableAndMockConnection(connectionPool));
            listOfThreads.add(thread);
        }
        for (int i = 0; i < amountOfConnections; i++) {
            listOfThreads.get(i).start();
        }





    }
}
