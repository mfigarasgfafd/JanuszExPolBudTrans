package org.JanuszPol;

public class Manager extends User implements UserActions{

    public Manager(String login, String password) {
        super(login, password);
    }

    @Override
    public String login() {
        return UserUtility.getInstance().login(super.getLogin(),super.getPassword());
    }
    @Override
    public void register() {
        UserUtility.getInstance().register(super.getLogin(),super.getPassword());
    }
    // TODO: 25.05.2024 eq class tutaj tez
    public void addProduct(String name,Double pricePerDay){
        if (UserUtility.getInstance().isLoggedIn(super.getLogin())){
            ProductDatabase.getInstance().addProduct(new Product(name,pricePerDay));
        }
        else System.out.println("user not logged in");
    }
    public void fireTechnician(String loginOfTechnician){

        if (UserUtility.getInstance().isLoggedIn(super.getLogin())){
            UserUtility.getInstance().removeAccount(loginOfTechnician);
        }
        else System.out.println("user not logged in");
    }



}
