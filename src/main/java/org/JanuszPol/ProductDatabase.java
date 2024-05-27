package org.JanuszPol;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {

    private List<Product> productList = new ArrayList<>();
    static ProductDatabase instance;


    private ProductDatabase() {
        System.out.println("Database created");
    }

    public static ProductDatabase getInstance(){
        if (instance==null){
            instance=new ProductDatabase();
        }
        return instance;
    }

    public void addProduct(Product product){
        productList.add(product);
    }


    public List<Product> getProductList() {
        return productList;
    }
}
