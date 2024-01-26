# hardware store
Progressive exercises of QA automation training, using maven and git.

## Project description:
In this project, we have a hardware store that sells different products.

<p align="center">
<img src="https://t4.ftcdn.net/jpg/03/39/67/57/360_F_339675724_zKIsiEcSss6x2KOXUfHMfBrK9b0qbYCQ.jpg" alt="Image of a hardware store" width="300" height="200">
</p>

We represent this product using classes.
We can see the classes and some examples of products that they are going to content:
1. ConstructionProduct: nails, screws, cement, sand etc. we sell it by it units, for ex.
   10 kg of sand.
2. ElectricProduct: cables, electric tape, socket outlet,power drills, hole puncher, etc.
3. HandTool: hammer, hand saw, etc.
4. GardenProduct:shovel, plant pot, etc.
5. HouseholdItem: kettle, broom, brush, etc.
6. WaterProduct:water filter, water pump, etc.
7. GasProduct: gas valve, etc.

Besides that, we have the persons that interact with the store these are:
1. Employee: these are the employees of the store and could be: seller, deposit or owner
2. Supplier: the one that sells us the products
3. BigClient: at the moment, the store only works with big clients that are an small amount and are registered.

## Exercises and references:

### 30/11/2023
* Create 2 Threads using Runnable and Thread.
* Initialize pool with 5 sizes.
  Load Connection Pool using threads and Thread Pool(7 threads).
  5 threads should be able to get the connection.
  2 Threads should wait for the next available connection.
  The program should wait as well.
* Implement 4th part but with IFuture and CompletableStage.

### Solution
The classes ThreadWithThread an ThreadWithRunnable were created in the mythreads package.
The example could be seen in the main method.

The Connection pool was created in the connectionpool package
The MockConnection also was created
In this connection pool 
* 5 threads should be able to get the connection.
* 2 Threads should wait for the next available connection.

The example of this implementation is in the main method

All previous console output and data in the main method was deleted 
to see only this exercise results.





