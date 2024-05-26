package org.JanuszPol;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class Calendar {

    // FIXME : nwm czy to dobrze jest ale chyba działa jakos (dodana test klasa jakbys chcial sprawdzic)

    // mapa przechowuje rezerwacje
    // !!!!!!!!! klucz to dzień w formacie yyyy-MM-dd, wartość to lista<ID> produktów zajętych w tym dniu
    private Map<String, List<Integer>> reservations;

    public Calendar() {
        reservations = new HashMap<>();
    }

    // sprawdz czy produkt jest zajęty w podanym przedziale czasowym
    public boolean checkIfBusy(int productId, Timestamp timeStart, Timestamp timeEnd) {
        // convert Timestamp --> String [ formacie yyyy-MM-dd   ]
        String startDay = new java.text.SimpleDateFormat("yyyy-MM-dd").format(timeStart);
        String endDay = new java.text.SimpleDateFormat("yyyy-MM-dd").format(timeEnd);

        // iterj po kazdym dniu w kalendarzu od - do sprawdzajac czy jest zarezerwowany dany produkt
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(timeStart);
        while (cal.getTime().before(timeEnd) || cal.getTime().equals(timeEnd)) {
            String dayKey = new java.text.SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

            // sprawdz czy w danym dniu produkt jest już zarezerwowany
            if (reservations.containsKey(dayKey) && reservations.get(dayKey).contains(productId)) {
                return true; // produkt zajety 🎤🦘
            }

            // przejdz do następnego dnia
            cal.add(java.util.Calendar.DATE, 1);
        }

        return false; // produkt dostepny 🎈🎈🎈🎈🎈
    }

    // rezerwuj produkt na podany przedział czasowy
    public void reserveTime(int productId, Timestamp timeStart, Timestamp timeEnd) {
        // convert Timestamp --> String [ formacie yyyy-MM-dd   ]
        String startDay = new java.text.SimpleDateFormat("yyyy-MM-dd").format(timeStart);
        String endDay = new java.text.SimpleDateFormat("yyyy-MM-dd").format(timeEnd);

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(timeStart);
        while (cal.getTime().before(timeEnd) || cal.getTime().equals(timeEnd)) {
            String dayKey = new java.text.SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

            // dodaj ID produktu do listy zajętych produktów w danym dniu
            reservations.computeIfAbsent(dayKey, k -> new ArrayList<>()).add(productId);

            // przejdz do nastepnego dnia
            cal.add(java.util.Calendar.DATE, 1);
        }
    }
}
