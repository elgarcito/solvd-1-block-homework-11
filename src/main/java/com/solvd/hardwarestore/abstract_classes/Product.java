package com.solvd.hardwarestore.abstract_classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
This abstract class is going to have the basic field that a product should have and methods that it should contain
 */
public abstract class Product {
    private static final Logger LOGGER= LogManager.getLogger(Product.class);
    private String productName;// resume of the product name
    private String productDescription;//Full description of the product
    private double productWeight;//The weight of the product
    private int stock;//The units that we have

    public String getProductName() {
        return productName;
    }

    //Constructor of the abstract class
    public Product(String productName, String productDescription){
        this.productName=productName;
        this.productDescription=productDescription;
    }

    //end constructor



    //Getters and setter of the abstract class
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(double productWeight) {
        this.productWeight = productWeight;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //end of getter and setters


}
