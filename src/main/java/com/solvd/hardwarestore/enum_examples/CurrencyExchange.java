package com.solvd.hardwarestore.enum_examples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum CurrencyExchange {
    EURO (0.91, EmergencyExchangePhonenNumber.EURO_EXCHANGER),
    COLOMBIAN_PESO (3993.10, EmergencyExchangePhonenNumber.COLOMBIAN_PESO_EXCHANGER),
    CHINESE_YUAN (7.09, EmergencyExchangePhonenNumber.YUAN_EXCHANGER);
    private final double EXCHANGE_RATE;
    private final EmergencyExchangePhonenNumber NUMBER_OF_EXCHANGER;

    private static final Logger LOGGER= LogManager.getLogger(CurrencyExchange.class);

     CurrencyExchange(double exchangeRate, EmergencyExchangePhonenNumber NUMBER_OF_EXCHANGER) {

         this.EXCHANGE_RATE =exchangeRate;
         this.NUMBER_OF_EXCHANGER=NUMBER_OF_EXCHANGER;
    }

     public static void showExchangeRate(){
        for (CurrencyExchange money: CurrencyExchange.values()) {
            LOGGER.info("The exchange rate for 1 USD to : "+ money+" is: " + money.EXCHANGE_RATE+
                    "If you have doubts according exchange rate call the following number: "
                    +money.NUMBER_OF_EXCHANGER);
        }
    }

     public static void changeAmount(double moneyAmount){
        LOGGER.info(moneyAmount+"$ USD = Euro: "+ CurrencyExchange.EURO.EXCHANGE_RATE *moneyAmount+"$");
        LOGGER.info(moneyAmount+"$ USD = Colombian peso: "+ CurrencyExchange.COLOMBIAN_PESO.EXCHANGE_RATE *moneyAmount+"$");
        LOGGER.info(moneyAmount+"$ USD = Chinese Yuan: "+ CurrencyExchange.CHINESE_YUAN.EXCHANGE_RATE *moneyAmount+"$");
    }



}
