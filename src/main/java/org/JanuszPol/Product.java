package org.JanuszPol;

public class Product {
    String name;
    Double pricePerDay;
    // TODO: 25.05.2024 equipmentClass


    public Product(String name, Double pricePerDay) {
        this.name = name;
        this.pricePerDay = pricePerDay;
    }

    public void printInfo(){
        System.out.println(name + " " + "cena: " + pricePerDay.toString());

    }

    public String getName() {
        return name;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }
}
