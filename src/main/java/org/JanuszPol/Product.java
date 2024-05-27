package org.JanuszPol;

public class Product {
    String name;
    Double pricePerDay;
    // TODO: 25.05.2024 equipmentClass
    int amountInStock;

    ProductCalendar productCalendar = new ProductCalendar();
    public Product(String name, Double pricePerDay, int amountInStock) {
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.amountInStock = amountInStock ;
    }
    public Product(String name, Double pricePerDay) {
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.amountInStock = 1;
    }


    public Integer getAmountInStock(){
        return amountInStock;
    }


    public void printInfo(){
        System.out.println(name + " " + "cena: " + pricePerDay.toString() + " dostępnych: " + amountInStock);

    }

    public String getName() {
        return name;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }
}
