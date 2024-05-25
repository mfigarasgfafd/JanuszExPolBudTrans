package org.JanuszPol;

import java.util.*;

public class UserUtility {

    private List<User> users = new ArrayList<>();
    private Map<User, String> loggedUsers = new HashMap<>();

    // Private static instance of the singleton class
    private static UserUtility instance;

    private UserUtility() {}

    public static UserUtility getInstance() {
        if (instance == null) {
            instance = new UserUtility();
        }
        return instance;
    }

    public void register(String login, String password){
        users.add(new User(login, password));
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
}