package org.JanuszPol;

import java.util.Comparator;

public class ProductCatalog {
    static ProductDatabase productDatabase = ProductDatabase.getInstance();
    static UserUtility userUtility = UserUtility.getInstance();


    public static void displayCatalog(){
        for (Product product:productDatabase.getProductList()) {
            product.printInfo();
        }
    }

    public static void sortByName() {
        productDatabase.getProductList().sort(Comparator.comparing(Product::getName));
    }

    public static void sortByPrice() {
        productDatabase.getProductList().sort(Comparator.comparing(Product::getPricePerDay));
    }

















}
