package com.solvd.hardwarestore.products;
import com.solvd.hardwarestore.abstract_classes.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class HouseholdItem extends Product {
    private static final Logger LOGGER= LogManager.getLogger(HouseholdItem.class);
    private boolean itIsASet;//Checks if the product is a set or not, for example, a set of kitchen knives
    private int unitsPerSet; //If it is a set it tells how many items it has
    private static ArrayList<HouseholdItem> householdItemArrayList=new ArrayList<>();

    //Constructor
    public HouseholdItem(String productName,String productDescription){
        super(productName,productDescription);
    }
    //end constructor

    //Getters and setters

    public boolean isItIsASet() {
        return itIsASet;
    }

    public void setItIsASet(boolean itIsASet) {
        this.itIsASet = itIsASet;
    }

    public int getUnitsPerSet() {
        return unitsPerSet;
    }

    public void setUnitsPerSet(int unitsPerSet) {
        this.unitsPerSet = unitsPerSet;
    }

    // End getters and setters

    //Override equal, hashcode and toString methods.
    @Override
    public String toString(){
        return  "The resume name of the product is:\n"+this.getProductName()
                +"\nThe full description is:\n"+this.getProductDescription();
    }
    //end Override equal, hashcode and toString methods.

    //List methods
    public static ArrayList<HouseholdItem> getCopyOfHouseholdItemArrayList() {
        return new ArrayList<>(HouseholdItem.householdItemArrayList);
    }

    public static void addHouseholdItemToArrayList(HouseholdItem householdItem){
        HouseholdItem.householdItemArrayList.add(householdItem);
    }

    //End list methods


}
