package com.solvd.hardwarestore.products;
import com.solvd.hardwarestore.abstract_classes.Product;
import com.solvd.hardwarestore.created_interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class ElectricProduct extends Product implements Available, Costable, Priceable, Sellable, TransactionDateable {
    //The static product counter expand itself any time a product is created but initialize in 0 every time the
    //program initiate
    static {
        electricProductCounter=0;
    }
    private static final Logger LOGGER= LogManager.getLogger(ElectricProduct.class);
    private double voltageRate;//The voltage admitted for the product in V (volts)
    private double power;//The power consumed for the product in kW (kiloWatt)
    private String electricId;// The unique id for that product
    public static int electricProductCounter;// The number of products created
    private static ArrayList<ElectricProduct> electricProductArrayList=new ArrayList<>(); //List of employees created

    //Constructor

    public ElectricProduct(String productName,String productDescription){
        super(productName,productDescription);
        this.setElectricId();
        electricProductCounter++;
    }

    //End constructor

    //Getters and setters
    public double getVoltageRate() {
        return voltageRate;
    }

    public void setVoltageRate(double voltageRate) {
        this.voltageRate = voltageRate;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public String getElectricId() {
        return electricId;
    }

    public void setElectricId() {
        this.electricId = "EL"+this.hashCode();
    }

    //End Getters and setters

    //Override equal, hashcode and toString methods.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectricProduct)) return false;
        ElectricProduct that = (ElectricProduct) o;
        return Objects.equals(electricId, that.electricId);
    }

    @Override
    public int hashCode() {
        if(Objects.hash(this.getProductName(),this.getProductDescription())<0){
            return Objects.hash(this.getProductName(),this.getProductDescription())*-1;
        }
        return Objects.hash(this.getProductName(),this.getProductDescription());
    }

    @Override
    public String toString(){
        return "The resume name of the product is:\n"+this.getProductName()
                +"\nThe full description is:\n"+this.getProductDescription();
    }


    //end override equal, hashcode and toString methods.

    //interfaces methods
    @Override
    public boolean checkAvailability(int stock) {
        if (this.getStock()>0){
            LOGGER.info("You have enough stock to sell this electric product, your stock is: "+this.getStock()+" units\n");
            return true;
        }else {
            LOGGER.warn("You have not enough stock to sell this electric product, your stock is: "+this.getStock()+" units\n");
            return false;
        }
    }

    @Override
    public double defineCost(double supplierCost,double transportCost,double anotherCost){
        double cost=supplierCost+transportCost+anotherCost;
        LOGGER.info("The final cost of: "+this.getProductName()+" is "+cost+" usd\n");
        return cost;
    }

    @Override
    public double definePrice(double cost, double winPercentage) {
        DecimalFormat df = new DecimalFormat("0.00");
        double price=cost*(1+winPercentage/100);
        LOGGER.info("The final price is of: "+this.getProductName()+" is "+df.format(price)+" usd\n");
        return price;
    }

    @Override
    public void removeStockDueSell(int amountSold) {
        boolean thereIsStock=checkAvailability(this.getStock());
        if(thereIsStock && amountSold<=this.getStock()){
            int newStock =this.getStock()-amountSold;
            this.setStock(newStock);
            LOGGER.info("Your new stock of this electric product is: "+newStock+"\n");
        }else{
            LOGGER.warn("You can't sell that amount of this electric product\n");
        }
    }

    @Override
    public String transactionDate(){
        String date="the day of the transaction is \n" +
                LocalDate.now().getDayOfMonth() +" of "+LocalDate.now().getMonth();
        LOGGER.info(date);
        return date;
    }
    //end interfaces methods

    //Static method
    public static void showAmountOfElectricProducts(){
        LOGGER.info("The amount of electric products is: "+ElectricProduct.electricProductCounter);
    }
    //End Static method

    //List methods
    public static ArrayList<ElectricProduct> getCopyOfElectricProductArrayList() {
        return new ArrayList<ElectricProduct>(ElectricProduct.electricProductArrayList);
    }

    public static void addElectricProductToArrayList(ElectricProduct electricProduct){
        ElectricProduct.electricProductArrayList.add(electricProduct);
    }
    //End list methods


}





