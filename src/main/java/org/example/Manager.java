package org.example;

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
}
