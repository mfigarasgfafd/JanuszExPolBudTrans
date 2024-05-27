package org.JanuszPol;

import java.sql.Timestamp;

public class Customer extends User implements UserActions {

    public Customer(String login, String password) {
        super(login, password);
    }

    @Override
    public String login() {
        return UserUtility.getInstance().login(super.getLogin(),super.getPassword());
    }

    Wallet wallet;
    public void addWallet(long creditCardNumber,int securityCode,Timestamp expirationDate){
        this.wallet = new Wallet(creditCardNumber,securityCode,expirationDate);

    }
    public Wallet getWalletInfo() {
        return this.wallet;
    }


    public void browseCatalog(){
        if (UserUtility.getInstance().isLoggedIn(super.getLogin())){
            ProductCatalog.displayCatalog();
        }
        else System.out.println("user not logged in");
    }
    public void sortCatalogName(){

        if (UserUtility.getInstance().isLoggedIn(super.getLogin())){
            ProductCatalog.sortByName();
        }
        else System.out.println("user not logged in");

    }
    public void sortCatalogPrice(){

        if (UserUtility.getInstance().isLoggedIn(super.getLogin())){
            ProductCatalog.sortByPrice();
        }
        else System.out.println("user not logged in");

    }

    public void reportFaulty(){

    }




}
