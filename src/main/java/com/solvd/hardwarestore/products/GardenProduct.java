package com.solvd.hardwarestore.products;
import com.solvd.hardwarestore.abstract_classes.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class GardenProduct extends Product {
    private static final Logger LOGGER= LogManager.getLogger(GardenProduct.class);

    private boolean itsPoison;//Check if the product is poison or not
    private String gardenId;// the unique id for that product
    private static Set<GardenProduct> gardenProductHashSetList=new HashSet<>();//List of garden products

    //constructor
    public GardenProduct(String productName, String productDescription,boolean itsPoison){
        super(productName,productDescription);
        this.itsPoison=itsPoison;
        this.gardenId=setGardenId();


    }
    //End constructor

    //getter and setter

    public boolean isItsPoison() {
        return itsPoison;
    }

    public void setItsPoison(boolean itsPoison) {
        this.itsPoison = itsPoison;
    }

    public String getGardenId() {
        return gardenId;
    }

    public String setGardenId() {
        int a= this.hashCode();
        if (this.hashCode()<0){
            a*=-1;
        }
        return this.gardenId = "GR"+a;
    }
    //end getter and setter

    //Override equal, hashcode and toString methods.
    @Override
    public String toString(){
        String poison;
        if (this.itsPoison){
            poison="poisonous";
        }else {
            poison="non poisonous";}

        return  "The resume name of the product is:\n"+this.getProductName()
                +"\nThe full description is:\n"+this.getProductDescription()
                +"\nIt is a "+poison+" product";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GardenProduct)) return false;
        GardenProduct that = (GardenProduct) o;
        return itsPoison == that.itsPoison && Objects.equals(gardenId, that.gardenId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getProductName(), this.getProductDescription());
    }

    //end override equal, hashcode and toString methods.

    //List methods
    public static HashSet<GardenProduct> getCopyOfGardenProductHashSetList() {
        return new HashSet<>(GardenProduct.gardenProductHashSetList);
    }

    public static void addGardenProductToHashSetList(GardenProduct gardenProduct){
        GardenProduct.gardenProductHashSetList.add(gardenProduct);
    }

    //End list methods



}
