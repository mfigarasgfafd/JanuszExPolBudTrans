package org.JanuszPol;

import java.util.*;

public class UserUtility {

    private List<User> users = new ArrayList<>();
    private Map<User, String> loggedUsers = new HashMap<>();


    private static UserUtility instance;

    private UserUtility() {}

    public static UserUtility getInstance() {
        if (instance == null) {
            instance = new UserUtility();
        }
        return instance;
    }

    public void register(User user){
        users.add(user);
        System.out.println("Register complete!");
    }

    public String login(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                String randomString = generateRandomString(5);
                loggedUsers.put(user, randomString);
                System.out.println("User logged in with token: " + randomString);
                return randomString;
            }
        }
        System.out.println("Invalid login or password");
        return null;
    }

    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    public boolean removeAccount(String login) {
        User userToRemove = null;
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                userToRemove = user;
                break;
            }
        }
        if (userToRemove != null) {
            users.remove(userToRemove);
            loggedUsers.remove(userToRemove);
            System.out.println("User account removed!");
            return true;
        } else {
            System.out.println("User not found!");
            return false;
        }

    }

    public boolean isLoggedIn(String login) {
        for (User user : loggedUsers.keySet()) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public User getUserByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        System.out.println("User not found!");
        return null;
    }


}