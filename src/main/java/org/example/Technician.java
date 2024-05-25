package org.example;

public class Technician extends User implements UserActions{
    public Technician(String login, String password) {
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
