package com.solvd.hardwarestore.enum_examples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum EmergencyExchangePhonenNumber {
    YUAN_EXCHANGER("+254862",BankAccounts.BUSINESS_ACCOUNT),
    EURO_EXCHANGER("+684125",BankAccounts.ACCOUNTANT_ACCOUNT),
    COLOMBIAN_PESO_EXCHANGER("14848151",BankAccounts.OWNER_ACCOUNT),
    BANK_ACCOUNT_OWNER_NUMBER ("+32434354",BankAccounts.OWNER_ACCOUNT),
    BANK_ACCOUNT_BUSINESS_ACCOUNT_NUMBER ("+35584926248",BankAccounts.BUSINESS_ACCOUNT),
    BANK_ACCOUNT_ACCOUNTANT_ACCOUNT_NUMBER ("+3184148461",BankAccounts.ACCOUNTANT_ACCOUNT);

    private final String PHONE_NUMBER;
    private final BankAccounts BANK_ACCOUNT;
    private static final Logger LOGGER= LogManager.getLogger(EmergencyExchangePhonenNumber.class);

    EmergencyExchangePhonenNumber(String phoneNumber, BankAccounts bankAccount) {
        this.PHONE_NUMBER =phoneNumber;
        this.BANK_ACCOUNT=bankAccount;
    }

     public static void showNumbers(){
        for (EmergencyExchangePhonenNumber phoneNumber: EmergencyExchangePhonenNumber.values()) {
            LOGGER.info("The "+ phoneNumber+" phone number is: " + phoneNumber.PHONE_NUMBER+" and "+
                    "asociated with the following bank account "+phoneNumber.BANK_ACCOUNT);
        }
    }



}
