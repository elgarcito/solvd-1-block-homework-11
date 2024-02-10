package com.solvd.hardwarestore.enum_examples;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum BankAccounts {
    OWNER_ACCOUNT ("VU.LU.SU",32434354, EmergencyExchangePhonenNumber.BANK_ACCOUNT_OWNER_NUMBER),
    BUSINESS_ACCOUNT ("PU.CU.TU",384926248, EmergencyExchangePhonenNumber.BANK_ACCOUNT_BUSINESS_ACCOUNT_NUMBER),
    ACCOUNTANT_ACCOUNT ("RU.SU.MU",384148461, EmergencyExchangePhonenNumber.BANK_ACCOUNT_ACCOUNTANT_ACCOUNT_NUMBER);
    private final String ALIAS;
    private final long CBU;
    private final EmergencyExchangePhonenNumber PHONE_NUMBER;
    private static final Logger LOGGER= LogManager.getLogger(BankAccounts.class);
    BankAccounts(String alias, long cbu, EmergencyExchangePhonenNumber phoneNumber){
        this.ALIAS =alias;
        this.CBU =cbu;
        this.PHONE_NUMBER=phoneNumber;
    }
    public static void showBankAccounts(){

        for (BankAccounts account: BankAccounts.values()) {
            LOGGER.info("The bank account of "+ account +" has for alias: "
            +account.ALIAS +" and for CBU: "+account.CBU+" The emergency Phone number is: "+
                    account.PHONE_NUMBER);
        }
    }


}
