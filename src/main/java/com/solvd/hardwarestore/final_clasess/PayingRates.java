package com.solvd.hardwarestore.final_clasess;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PayingRates {
    private static final Logger LOGGER= LogManager.getLogger(PayingRates.class);

    //How much you pay per hour to a category of employee
    public static int productCounter;
    //initialization method using static block

    private final double SELLER_RATE=10.0;
    private final double DEPOSIT_RATE=8;
    private final double OWNER_RATE=15;



    public double getSellerRate() {
        return SELLER_RATE;
    }

    public double getDepositRate() {
        return DEPOSIT_RATE;
    }

    public double getOwnerRate() {
        return OWNER_RATE;
    }

    public final void showRates(){
        String message = "The rates per hour according to speciality are: \n" +
                "Seller: "+ getSellerRate() +" USD/h"+
                "\nDeposit employee: "+getDepositRate()+" USD/h"+
                "\nOwner: "+getOwnerRate()+" USD/h";
        LOGGER.info(message);
    }
}
