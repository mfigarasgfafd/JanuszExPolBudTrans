package org.JanuszPol;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class Calendar {



    // mapa przechowuje rezerwacje
    // !!!!!!!!! klucz to dzień w formacie yyyy-MM-dd, wartość to lista<Product> produktów zajętych w tym dniu
    private Map<String, List<Product>> reservations;

    public Calendar() {
        reservations = new HashMap<>();
    }
    public Product getProduct(String dayKey, Product productId) {
        List<Product> productsForDay = reservations.get(dayKey);
        if (productsForDay != null) {
            for (Product product : productsForDay) {
                if (product.getName().equals(productId.getName())) {
                    return product;
                }
            }
        }
        return null; // Produkt nie istnieje w danym dniu lub nie ma rezerwacji
    }

    // sprawdz czy produkt jest zajęty w podanym przedziale czasowym
    public boolean checkIfBusy(Product productId, Timestamp timeStart, Timestamp timeEnd) {

        // convert Timestamp --> String [ formacie yyyy-MM-dd   ]
        String startDay = new java.text.SimpleDateFormat("yyyy-MM-dd").format(timeStart);
        String endDay = new java.text.SimpleDateFormat("yyyy-MM-dd").format(timeEnd);

        // iterj po kazdym dniu w kalendarzu od - do sprawdzajac czy jest zarezerwowany dany produkt
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(timeStart);

        Product tempProduct = null;

        while (cal.getTime().before(timeEnd) || cal.getTime().equals(timeEnd)) {
            String dayKey = new java.text.SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

            // sprawdz czy w danym dniu produkt jest już zarezerwowany
            tempProduct = getProduct(dayKey, productId);

            if (reservations.containsKey(dayKey) && reservations.get(dayKey).contains(productId)  && (tempProduct.getAmountInStock() - tempProduct.productCalendar.getReservedAmount(dayKey)) == 0) {
                return true; // produkt zajety 🎤🦘
            }

            // przejdz do następnego dnia
            cal.add(java.util.Calendar.DATE, 1);
        }


        return false; // produkt dostepny 🎈🎈🎈🎈🎈
    }

    // rezerwuj produkt na podany przedział czasowy
    public void reserveTime(Product productId, Timestamp timeStart, Timestamp timeEnd) {
        // convert Timestamp --> String [ formacie yyyy-MM-dd   ]
        String startDay = new java.text.SimpleDateFormat("yyyy-MM-dd").format(timeStart);
        String endDay = new java.text.SimpleDateFormat("yyyy-MM-dd").format(timeEnd);

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(timeStart);
        while (cal.getTime().before(timeEnd) || cal.getTime().equals(timeEnd)) {
            String dayKey = new java.text.SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

            // dodaj ID produktu do listy zajętych produktów w danym dniu
            reservations.computeIfAbsent(dayKey, k -> new ArrayList<>()).add(productId);
            productId.productCalendar.reserveProduct(dayKey);
            // przejdz do nastepnego dnia
            cal.add(java.util.Calendar.DATE, 1);
        }
    }
}
