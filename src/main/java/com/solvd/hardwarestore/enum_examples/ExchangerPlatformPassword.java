
package com.solvd.hardwarestore.enum_examples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum ExchangerPlatformPassword {
    YUAN_PASSWORD ("YUAN1234",ImportantEmails.YUAN_EXCHANGER_PLATFORM_EMAIL),
    EURO_PASSWORD ("EURO1234",ImportantEmails.EURO_EXCHANGER_PLATFORM_EMAIL),
    COLOMBIAN_PESO_PASSWORD ("COL1234",ImportantEmails.COLOMBIAN_EXCHANGER_PLATFORM_EMAIL);
    private final String ACCOUNT_PASSWORD;
    private final ImportantEmails EMAIL;

    private static final Logger LOGGER= LogManager.getLogger(CurrencyExchange.class);

    ExchangerPlatformPassword(String accountPassword, ImportantEmails email) {
        this.ACCOUNT_PASSWORD =accountPassword;
        this.EMAIL=email;
    }

    public static void showPasswords(){
        for (ExchangerPlatformPassword password: ExchangerPlatformPassword.values()) {
            LOGGER.info("The logger info and password for: "+ password.EMAIL+" is: " + password.ACCOUNT_PASSWORD);
        }
    }

}

