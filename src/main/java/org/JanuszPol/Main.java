package org.JanuszPol;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product tempProduct = null;
        Scanner scanner = new Scanner(System.in);
        Calendar calendar = new Calendar();
        // potrzebne
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp timeStart = null;
        Timestamp timeEnd = null;


        try{
            timeStart = new Timestamp(dateFormat.parse("2024-06-01 09:00:00").getTime());
            timeEnd = new Timestamp(dateFormat.parse("2024-06-03 18:00:00").getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Manager tomek = new Manager("tomek1","123");
        tomek.register();
        tomek.login();
        tomek.addProduct("koparka",20.20);
        tomek.addProduct("dźwig",23.1);
        tomek.addProduct("betoniarka",4.20);
        tomek.addProduct("buldożer",123.4, 2);

        // IMPORTANT: kiedy dodajesz produkt bez amount in stock to ustawia sie na 1 (nwm dlaczego nie dziala jak sie na 0 ustawiało, ale jak liczba ZEJDZIE do 0 to działa wtedy???)

        System.out.println(tomek.getSessionCode());

        Customer franek = new Customer("franek420","2131321");
        franek.register();
        franek.login();


        franek.browseCatalog();
        System.out.println();

            // TODO: log in
        String response = "";
        boolean running=true;
        while(running) {

            System.out.println("-----------MENU------------");
            System.out.println("0 - log in ");
            System.out.println("1 - show catalog");
            System.out.println("2 - rent");
            System.out.println("3 - add product [manager only]");
            response = scanner.nextLine();
            switch (response) {
                case "0":
                    System.out.println("log in tutaj !");
                    break;
                case "1":
                    franek.browseCatalog();
                    break;
                case "2":
                    System.out.println("provide model name: ");
                    String line = scanner.nextLine();

                    tempProduct = ProductCatalog.chooseProduct(line);

                    if(!calendar.checkIfBusy(tempProduct, timeStart, timeEnd)){
                        calendar.reserveTime(tempProduct, timeStart, timeEnd);
                        System.out.println("PRODUKT ZAREZERWOWANY POMYSLNIE");
                    } else {
                        // jesli zajety --> jakas wiadomosc 🕋
                        System.out.println("PRODUKT NIE JEST DOSTĘPNY W PODANYM OKRESIE CZASOWYM");
                    }

                    break;
                case "3":
                    System.out.println("add product syntax");
                    break;
                default:
                    running=false;
            }}


//        System.out.println(" testy tutaj : ");
//
//        Product testProduct = ProductCatalog.chooseProduct("betoniarka");
//
//
//        if(!calendar.checkIfBusy(testProduct, timeStart, timeEnd)){
//            calendar.reserveTime(testProduct, timeStart, timeEnd);
//            System.out.println("PRODUKT ZAREZERWOWANY POMYSLNIE");
//        } else {
//            // jesli zajety --> jakas wiadomosc 🕋
//            System.out.println("PRODUKT NIE JEST DOSTĘPNY W PODANYM OKRESIE CZASOWYM");
//        }
//
//        if(!calendar.checkIfBusy(testProduct, timeStart, timeEnd)){
//            calendar.reserveTime(testProduct, timeStart, timeEnd);
//            System.out.println("PRODUKT ZAREZERWOWANY POMYSLNIE");
//        } else {
//            // jesli zajety --> jakas wiadomosc 🕋
//            System.out.println("PRODUKT NIE JEST DOSTĘPNY W PODANYM OKRESIE CZASOWYM");
//        }
//        if(!calendar.checkIfBusy(testProduct, timeStart, timeEnd)){
//            calendar.reserveTime(testProduct, timeStart, timeEnd);
//            System.out.println("PRODUKT ZAREZERWOWANY POMYSLNIE");
//        } else {
//            // jesli zajety --> jakas wiadomosc 🕋
//            System.out.println("PRODUKT NIE JEST DOSTĘPNY W PODANYM OKRESIE CZASOWYM");
//        }


        } ;








    }




