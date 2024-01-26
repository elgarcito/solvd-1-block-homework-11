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

import com.solvd.hardwarestore.abstractclasses.Product;
import com.solvd.hardwarestore.person.BigClient;
import com.solvd.hardwarestore.person.Employee;
import com.solvd.hardwarestore.person.ProductSupplier;
import com.solvd.hardwarestore.products.*;
import com.solvd.hardwarestore.readwritefile.ReadingFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        //humans or companies
        BigClient bigClient=new BigClient("Edward Cullen","Edward@gmail.com","+224586634");
        ProductSupplier rinoMax= new ProductSupplier("Jason Krueger","jason@gmail.com","+12812516","sand");
        Employee carlosRusso = new Employee("carlos Russo", "123@gmail.com", "12345678", "Deposit");
        Employee joseAntonio = new Employee("Jose Antonio", "123@gmail.com", "12345678", "seller");

        //Products to use
        ConstructionProduct sand = new ConstructionProduct("Sand", "White sand", "Tn");
        //Creating ElectricProducts Objects
        ElectricProduct lightBulb = new ElectricProduct("Light bulb 2", "led light bulb");
        ElectricProduct lightBulb2 = new ElectricProduct("Light bulb 1", "led light bulb");
        ElectricProduct lightBulb3 = new ElectricProduct("Light bulb 4", "led light bulb");
        //Creating GardenProduct Objects
        GardenProduct gardenScissors = new GardenProduct("Big scissors", "Big size scissors to cut grass", false);
        GardenProduct gardenScissors1 = new GardenProduct("Medium scissors", "Medium size scissors to cut grass", false);
        GardenProduct gardenScissors2 = new GardenProduct("Small scissors", "Small size scissors to cut grass", false);
        //Creating GasProduct Objects
        GasProduct gasBurner = new GasProduct("Gas Burner", "Gas kitchen burner");
        GasProduct gasBurner2 = new GasProduct("Gas Burner", "Gas kitchen burner");
        gasBurner2.setStock(8);
        //Creating a HandTool Objects
        HandTool handSaw=new HandTool("Hand saw","Small hand saw");
        //Creating HouseholdItem Objects
        HouseholdItem broom =new HouseholdItem("Big broom","Industrial boom");
        HouseholdItem broom1 =new HouseholdItem("Small broom","House boom");
        //Creating a WaterProduct Object
        WaterProduct pump1=new WaterProduct("Excelsior pump","20 hp power pump");

        //Adding the new products to a product list
        ArrayList<Product> productList=new ArrayList<>();

        productList.add(gardenScissors);
        productList.add(gardenScissors1);
        productList.add(gasBurner);
        productList.add(gasBurner2);
        productList.add(lightBulb);
        productList.add(handSaw);
        productList.add(pump1);
        productList.add(broom1);
        productList.add(broom);


        //Getting an array of only electricProducts
        Stream<Product> streamElectricProducts= productList.stream();

        //1-This stream return a list of only electrical products. The list is Optional in case that there are nulls
        LOGGER.info("Stream example 1: return a list of only electrical products from an ArrayList<Products>");
        List<Optional<Product>> optionalProducts =  streamElectricProducts
                .filter(product->product instanceof ElectricProduct)
                .peek((product)-> LOGGER.info(product.getProductName()))
                .map(product -> Optional.of(product))
                .collect(Collectors.toList());
        System.out.println();

        optionalProducts.forEach(product -> LOGGER.info(product.get().getProductName()) );
        System.out.println();

        LOGGER.info("Stream example 2: return only the product that doesn't have its voltage set from a List<ElectricProduct>, and set it in 230V");
        //2- This stream use return only the product that doesn't have it voltage set and set it in 230V
        List<ElectricProduct> electricProductList=new ArrayList<>();
        electricProductList.add(lightBulb);
        electricProductList.add(lightBulb2);

        List<ElectricProduct> electricProductList1= electricProductList.stream()
                .filter(electricProduct -> electricProduct.getVoltageRate()==0)
                .map(electricProduct -> {electricProduct.setVoltageRate(230);
                    return electricProduct;})
                .collect(Collectors.toList());

        System.out.println();
        electricProductList1.
                forEach(electricProduct -> LOGGER.info("The product whose voltage was null was: "
                        +electricProduct.getProductName()+
                        " now it's voltage is: "+electricProduct.getVoltageRate()));
        System.out.println();

        //3-In this application of stream if we find any Electric product that doesn't have the voltage set,
        //You must correct it from the beginning
        LOGGER.info("Stream example 3: find any Electric product from a List<ElectricProduct> that doesn't have the voltage set");
        electricProductList1.add(lightBulb3);
        Optional<ElectricProduct> OptionalElectricProduct= electricProductList1.stream()
                .filter(electricProduct->electricProduct.getVoltageRate()==0.0)
                .findAny();

        String message= (OptionalElectricProduct
                .orElseGet(()->{ElectricProduct defaultProduct=new ElectricProduct("Default product"
                        ,"There wasn't any product");
            return defaultProduct;}).getProductName());
        LOGGER.info(String.format("The product %s has no voltage set ",message));

        // Path of the input file
        String inputFilePath = "src/main/resources/input.txt";

        //4- Find unique word in text
        ReadingFile.findUniqueWord("text",inputFilePath);

        //5-sort words in a file by their length
        String orderWordsByLengthOutput = "src/main/resources/orderWordsByLengthOutput.txt";
        ReadingFile.orderWordsByLength(inputFilePath,orderWordsByLengthOutput);

        //6 counts all the characters in a file spaces and punctuation are not counted
        ReadingFile.countCharacters(inputFilePath);

        //7 Find if there is a number written in our file
        ReadingFile.findAnyNumber(inputFilePath);



    }
}
