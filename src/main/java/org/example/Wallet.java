package org.example;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Wallet {

    private long creditCardNumber;
    private int securityCode;
    private Timestamp expirationDate;

    public Wallet(long creditCardNumber, int securityCode, Timestamp expirationDate) {
        this.creditCardNumber = creditCardNumber;
        this.securityCode = securityCode;
        this.expirationDate = expirationDate;
    }

    private void printInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        String formattedExpirationDate = dateFormat.format(expirationDate);

        System.out.println("Credit Card Number: " + creditCardNumber);
        System.out.println("Security Code: " + securityCode);
        System.out.println("Expiration Date: " + formattedExpirationDate);
    }




}
