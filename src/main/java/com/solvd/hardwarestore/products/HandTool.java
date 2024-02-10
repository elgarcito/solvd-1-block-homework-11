package com.solvd.hardwarestore.products;
import com.solvd.hardwarestore.abstract_classes.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HandTool extends Product {
    private static final Logger LOGGER= LogManager.getLogger(HandTool.class);
    protected boolean itCut;//If it cut like a knife, hand saw or axe
    protected boolean weatherProof;//if it is weatherproof
    protected boolean electricIsolated;//if it is or not electrically isolated
    protected String batteryType;//if it uses a battery and which type
    protected boolean oneHand;//if it uses one or two hands


    //Constructor
    public HandTool(String productName,String productDescription){
        super(productName,productDescription);
    }
    //End constructor

    //getter and setter

    //end getter and setter

}
