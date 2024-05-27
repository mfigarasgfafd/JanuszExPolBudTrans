package org.JanuszPol;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = new Calendar();

        Manager tomek = new Manager("tomek1","123");
        tomek.register();
        tomek.login();
        tomek.addProduct("koparka",20.20);
        tomek.addProduct("dźwig",23.1);
        tomek.addProduct("betoniarka",4.20);

        System.out.println(tomek.getSessionCode());

        Customer franek = new Customer("franek420","2131321");
        franek.register();
        franek.login();


        franek.browseCatalog();
        System.out.println();










   }


}
