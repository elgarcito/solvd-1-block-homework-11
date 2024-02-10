package com.solvd.hardwarestore.enum_examples;

public enum ImportantEmails {
    YUAN_EXCHANGER_PLATFORM_EMAIL("YUAN_yuam@gmail.com",ExchangerPlatformPassword.YUAN_PASSWORD),
    EURO_EXCHANGER_PLATFORM_EMAIL("euro_yes_yes@gmail.com",ExchangerPlatformPassword.EURO_PASSWORD),
    COLOMBIAN_EXCHANGER_PLATFORM_EMAIL("vivaElpesocol@gmail.com",ExchangerPlatformPassword.COLOMBIAN_PESO_PASSWORD);

    private final String EMAIL;

    private final ExchangerPlatformPassword PASSWORD;
    ImportantEmails(String email, ExchangerPlatformPassword password){
        this.EMAIL=email;
        this.PASSWORD=password;
    }

     public static String [] getEmails(){
        String [] arrayWithEmails=new String[3];
        arrayWithEmails[0]= YUAN_EXCHANGER_PLATFORM_EMAIL.EMAIL;
        arrayWithEmails[1]= EURO_EXCHANGER_PLATFORM_EMAIL.EMAIL;
        arrayWithEmails[2]= COLOMBIAN_EXCHANGER_PLATFORM_EMAIL.EMAIL;
        /*
        for (String c:arrayWithEmails) {
            System.out.println(c);
        }

         */
        return arrayWithEmails;
    };

}
