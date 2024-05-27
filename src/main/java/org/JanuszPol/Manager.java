package org.JanuszPol;

public class Manager extends User implements UserActions {

    public Manager(String login, String password) {
        super(login, password);
    }

    @Override
    public String login() {
        return UserUtility.getInstance().login(super.getLogin(), super.getPassword());
    }

    @Override
    public void register() {
        UserUtility.getInstance().register(super.getLogin(), super.getPassword());
    }

    // Metoda addProduct z dwoma argumentami (name, pricePerDay)
    public void addProduct(String name, Double pricePerDay) { // 2 wartosci constructor
        addProduct(name, pricePerDay, 1); // Wywołanie metody z trzema argumentami z domyślną wartością dla amountInStock
    }

    public void addProduct(String name, Double pricePerDay, Integer amountInStock) {
        if (UserUtility.getInstance().isLoggedIn(super.getLogin())) {
            ProductDatabase.getInstance().addProduct(new Product(name, pricePerDay, amountInStock));
        } else {
            System.out.println("user not logged in");
        }
    }

    public void fireTechnician(String loginOfTechnician) {
        if (UserUtility.getInstance().isLoggedIn(super.getLogin())) {
            UserUtility.getInstance().removeAccount(loginOfTechnician);
        } else {
            System.out.println("user not logged in");
        }
    }
}
