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
import com.solvd.hardwarestore.enumexamples.BankAccounts;
import com.solvd.hardwarestore.person.Employee;
import com.solvd.hardwarestore.products.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.reflect.*;
import java.util.Arrays;
public class Main {
    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        //Reflection exercises
        ElectricProduct lightBulb3 = new ElectricProduct("Light bulb 4", "led light bulb");
        String innerClass="com.solvd.hardwarestore.person.Employee";

        try {
            //Created a new instance of an employee using reflection
            Class<Employee> empClass= (Class<Employee>) Class.forName(innerClass);
            Constructor<Employee> constEmployee= empClass.getDeclaredConstructor(String.class,String.class,String.class,String.class);
            Employee javierGomez=constEmployee.newInstance("Javier Gomez","javo@gmail.com","+5412842","seller");
            LOGGER.info(javierGomez.toString());
            //Accesing a field of an electric product created using relection
            Class<ElectricProduct> electricProductClass =(Class<ElectricProduct>) Class.forName("com.solvd.hardwarestore.products.ElectricProduct");
            //Accesing it SuperClass via reflection
            Class<Product> productClass =(Class<Product>) Class.forName("com.solvd.hardwarestore.abstractclasses.Product");
            Field voltageRateReflection= electricProductClass.getDeclaredField("voltageRate");
            Field productDescriptionReflection= productClass.getDeclaredField("productDescription");
            productDescriptionReflection.setAccessible(true);
            voltageRateReflection.setAccessible(true);
            LOGGER.info("The description of Light bulb3, accessed with reflection is: "+ productDescriptionReflection.get(lightBulb3));
            LOGGER.info("The voltage rate of Light bulb3, accessed with reflection is: "+ voltageRateReflection.get(lightBulb3)+" V");
            //Changing a field of an electric product created using relection
            Field powerField =electricProductClass.getDeclaredField("power");
            powerField.setAccessible(true);
            powerField.set(lightBulb3,1000000);
            LOGGER.info(String.format("The power, accessed with reflection is: %s",lightBulb3.getPower()));
            //Getting the modifier of a field
            String modifierTypeOfFieldWithReflexion = Modifier.toString(powerField.getModifiers());
            LOGGER.info(modifierTypeOfFieldWithReflexion);

            //Using a method inside electric product using reflection
            Method checkAvailabilityReflection= electricProductClass.getMethod("checkAvailability", int.class);
            checkAvailabilityReflection.setAccessible(true);
            LOGGER.info(checkAvailabilityReflection.invoke(lightBulb3,23));
            //Getting the parameters of this method
            Parameter[] parametersUsed=checkAvailabilityReflection.getParameters();
            Arrays.stream(parametersUsed)
                    .forEach(param -> {LOGGER.info("The parameter name for this method is: "+param.getName()
                            +", the parameter type is: "+param.getType());});

            //Another method using a getter
            Method getElectricIdReflection=electricProductClass.getMethod("getElectricId");
            getElectricIdReflection.setAccessible(true);
            LOGGER.info(getElectricIdReflection.invoke(lightBulb3));
            //Getting the modifier of this method
            String modifierTypeOfFieldWithReflexion1 = Modifier.toString(getElectricIdReflection.getModifiers());
            LOGGER.info("The modifier of this method is: "+modifierTypeOfFieldWithReflexion1);
            //Getting the return type
            LOGGER.info("The return Type of this method is: "+getElectricIdReflection.getReturnType());



            //Using reflexion to acces into an enum
            Class<BankAccounts> bankAccountWithReflexion= (Class<BankAccounts>) Class.forName("com.solvd.hardwarestore.enumexamples.BankAccounts");
            //Check if it is an enum
            LOGGER.info(bankAccountWithReflexion.isEnum());
            //Accesing the enum types with reflexion and put them into an array
            BankAccounts[] insideEnum = bankAccountWithReflexion.getEnumConstants();

            for (BankAccounts value: insideEnum){
                Field enumField2= bankAccountWithReflexion.getDeclaredField("ALIAS");
                enumField2.setAccessible(true);
                LOGGER.info(enumField2.get(value));
            }

            //Check if the field is a constant or not
            Field enumField= bankAccountWithReflexion.getDeclaredField("ACCOUNTANT_ACCOUNT");
            enumField.setAccessible(true);
            LOGGER.info(enumField.isEnumConstant());



        }catch (NoClassDefFoundError|NoSuchMethodException|InvocationTargetException
                |InstantiationException|IllegalAccessException|NoSuchFieldException e){
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
