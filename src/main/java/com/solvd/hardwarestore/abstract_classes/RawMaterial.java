package com.solvd.hardwarestore.abstract_classes;

import com.solvd.hardwarestore.person.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.function.*;

//Here we have the kind of product that tou can use to make another, for example, sand, gasoline
//or all the kind of product that you don't sell by unit
public abstract class RawMaterial {
    private static final Logger LOGGER= LogManager.getLogger(RawMaterial.class);
    private String rawMaterialName;
    private String rawMaterialDescription;
    private String unitType;//For example, a ton, kg, lt


    //Constructor
    public RawMaterial(String rawMaterialName, String rawMaterialDescription, String unitType) {
        this.rawMaterialName = rawMaterialName;
        this.rawMaterialDescription = rawMaterialDescription;
    }
    //End constructor

    //Getter and setter

    public String getRawMaterialName() {
        return rawMaterialName;
    }

    public void setRawMaterialName(String rawMaterialName) {
        this.rawMaterialName = rawMaterialName;
    }

    public String getRawMaterialDescription() {
        return rawMaterialDescription;
    }

    public void setRawMaterialDescription(String rawMaterialDescription) {
        this.rawMaterialDescription = rawMaterialDescription;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }


    //end getter and setter

    //Abstract method
    /*
    This abstract method tells us if we need a special license to buy that product. It uses the license of the product according
    to the type of product, for example, some kind of poison.
     */
    public abstract boolean checkLicence(boolean needLicense, String licenseId, int licenseNumberLength);
    //end Abstract method

    //Functions from java.util.function
    //This methods tells an employee
    // How to separate gasoline and sand
    // In how many recipents or bags
    //And the estimated time of work to do it
    //Also give you the transaction date
    public static String separateProduct(String materialType, double amount ,Employee employee){
        if (amount==0 | !materialType.equals("sand") & !materialType.equals("gasoline")) {
            return "there was no product amount added, or the option isn't sand or gasoline please correct it.";
        }
        if(amount<10){
            return "The minimun amount of gasoline is 10 lts";
        } else if (amount<100 & materialType.equals("sand")) {
            return "The minimun amount of sand  is 100 kgr";
        }


        //Function
        Function<String,Integer> dividedProduct= typeOfProduct ->{
            if (typeOfProduct.equals("sand")||typeOfProduct.equals("Sand")){
                //A bag of 100 kg
                return 100;
            } else if (typeOfProduct.equals("gasoline")||typeOfProduct.equals("Gasoline")) {
                //In special recipents of 10 lts.
                return 10;
            }
            return 0;
        };

        //BiFunction
        BiFunction<String,Integer,Integer> hoursOfWork=(typeOfProduct, amountOfUnits)->{
            if (typeOfProduct.equals("sand")||typeOfProduct.equals("Sand")){
                //30 minutes to prepare every bag with sand
                return (amountOfUnits*10);
            } else if (typeOfProduct.equals("gasoline")||typeOfProduct.equals("Gasoline")) {
                //5 minutes to prepare every bag with sand
                return  (amountOfUnits*5);
            }
            return  0;
        };

        //Predicate
        Predicate<Integer> checkWorkers = hours-> {
            //if the time is below 120 min(2 hours) it can be done by a single employee
            return (hours<=120);
        };
        //BiConsumer
        BiConsumer<Employee,Integer> assignWorkToEmployee=(employee1, extraHours)->{
            String message ="You have been asigned with "+extraHours+" min of extra " +
                    "work ask the manager for details" ;
            LOGGER.info(message);
        };
        //Supplier
        Supplier<LocalDateTime> transactionDate =()-> LocalDateTime.now();

        Double divisionResult= amount/dividedProduct.apply(materialType);
        Integer roundDivision=divisionResult.intValue();
        Integer hoursWorked=hoursOfWork.apply(materialType,roundDivision);
        if(!checkWorkers.test(hoursWorked)){
            return "This job must be done by two persons please talk to the manager";
        };
        assignWorkToEmployee.accept(employee,hoursWorked);
        return "The work was assigned to "+employee.getPersonName()+".The date: " +transactionDate.get()+ ".\n" +
                "She/He must do: "+ roundDivision+ " bags or recipents of "+ materialType+ ".\n" +
                "with an estimated time of: "+hoursWorked+" min.";
    }

}
