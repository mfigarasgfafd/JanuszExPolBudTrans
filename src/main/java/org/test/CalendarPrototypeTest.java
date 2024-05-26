package org.test;

import org.JanuszPol.Calendar;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CalendarPrototypeTest {
    public static void main(String[] args) {
    Calendar calendar = new Calendar();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // przykladowe id do testu
    int productId = 2137;


    // tutaj jest formatowanie daty --> przykładowe zarezerwowanie od - do
    Timestamp timeStart = null;
    Timestamp timeEnd = null;
    try{
        timeStart = new Timestamp(dateFormat.parse("2024-06-01 09:00:00").getTime());
        timeEnd = new Timestamp(dateFormat.parse("2024-06-03 18:00:00").getTime());
    } catch (ParseException e) {
        e.printStackTrace();
    }

    // przykłady praktyczne tutaj ============

    // test1 - sprawdzenie czy produkt jest dostępny w przedziale czasowym jak tak to rezerwacja
    boolean isBusy = calendar.checkIfBusy(productId, timeStart, timeEnd);
        if (!isBusy) {
        // jesli dostępny --> zrób rezerwacje
        calendar.reserveTime(productId, timeStart, timeEnd);
        System.out.println("PRODUKT ZAREZERWOWANY POMYSLNIE");
    } else {
        // jesli zajety --> jakas wiadomosc 🕋
        System.out.println("PRODUKT NIE JEST DOSTĘPNY W PODANYM OKRESIE CZASOWYM");
    }

        // tutaj test - próba zarezerwowania tak jak wcześniej identycznie - powinien oddać że nie jest dostępny
    isBusy = calendar.checkIfBusy(productId, timeStart, timeEnd);
        if (!isBusy) {
            // jesli dostępny --> zrób rezerwacje
            calendar.reserveTime(productId, timeStart, timeEnd);
            System.out.println("PRODUKT ZAREZERWOWANY POMYSLNIE");
        } else {
            // jesli zajety --> jakas wiadomosc 🕋
            System.out.println("PRODUKT NIE JEST DOSTĘPNY W PODANYM OKRESIE CZASOWYM");
        }


}
}
