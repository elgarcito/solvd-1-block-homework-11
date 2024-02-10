package com.solvd.hardwarestore.products;
import com.solvd.hardwarestore.abstract_classes.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WaterProduct extends Product {
    private static final Logger LOGGER= LogManager.getLogger(WaterProduct.class);

    double maxPressure;//Max pressure of the water component
    //Constructor
    public WaterProduct(String productName,String productDescription){
        super(productName,productDescription);
    }
    //End constructor

    //Getter and setter
    public double getMaxPressure() {
        return maxPressure;
    }

    public void setMaxPressure(double maxPressure) {
        this.maxPressure = maxPressure;
    }
    //end getter and setter
}
