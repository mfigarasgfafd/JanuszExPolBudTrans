package org.JanuszPol;

import java.util.*;

public class ProductCalendar {
    private Map<String, Integer> reservations;

    public ProductCalendar() {
        reservations = new HashMap<>();
    }

    // Metoda do rezerwacji produktu na dany dzień
    public void reserveProduct(String dayKey) {
        reservations.merge(dayKey, 1, Integer::sum);
    }

    // Metoda do sprawdzania dostępności produktu na dany dzień
    public boolean isProductAvailable(String dayKey) {
        return reservations.getOrDefault(dayKey, 0) < 1;
    }

    // Metoda do anulowania rezerwacji produktu na dany dzień
    public void cancelReservation(String dayKey) {
        reservations.computeIfPresent(dayKey, (k, v) -> v > 1 ? v - 1 : null);
    }

    // Metoda zwracająca ilość zarezerwowanych produktów w danym dniu
    public int getReservedAmount(String dayKey) {
        return reservations.getOrDefault(dayKey, 0);
    }




}
