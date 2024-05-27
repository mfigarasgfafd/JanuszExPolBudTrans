package org.JanuszPol;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
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

        // TODO: menu, get konkretny produkt z katalogu zeby to jakos zwracalo produkt który można użyć jako jakis np. chosenProduct i wtedy rezerwacja tak samo jak na dole testProduct jest


        System.out.println(" testy tutaj : ");

        Product testProduct = ProductCatalog.chooseProduct("betoniarka");


        if(!calendar.checkIfBusy(testProduct, timeStart, timeEnd)){
            calendar.reserveTime(testProduct, timeStart, timeEnd);
            System.out.println("PRODUKT ZAREZERWOWANY POMYSLNIE");
        } else {
            // jesli zajety --> jakas wiadomosc 🕋
            System.out.println("PRODUKT NIE JEST DOSTĘPNY W PODANYM OKRESIE CZASOWYM");
        }

        if(!calendar.checkIfBusy(testProduct, timeStart, timeEnd)){
            calendar.reserveTime(testProduct, timeStart, timeEnd);
            System.out.println("PRODUKT ZAREZERWOWANY POMYSLNIE");
        } else {
            // jesli zajety --> jakas wiadomosc 🕋
            System.out.println("PRODUKT NIE JEST DOSTĘPNY W PODANYM OKRESIE CZASOWYM");
        }
        if(!calendar.checkIfBusy(testProduct, timeStart, timeEnd)){
            calendar.reserveTime(testProduct, timeStart, timeEnd);
            System.out.println("PRODUKT ZAREZERWOWANY POMYSLNIE");
        } else {
            // jesli zajety --> jakas wiadomosc 🕋
            System.out.println("PRODUKT NIE JEST DOSTĘPNY W PODANYM OKRESIE CZASOWYM");
        }


        } ;








    }



