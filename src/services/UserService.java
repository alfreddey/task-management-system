package services;

import models.User;

import java.util.ArrayList;

public class UserService {
    private static UserService service;
    private ArrayList<User> users = new ArrayList<>();

    // Constructors
    private UserService() {};

    // Static methods
    public static UserService getService() {
        if (service == null) {
            service = new UserService();
        }

        return service;
    }

    // Object Methods
    public User signIn(String email) {
        if (email.isEmpty()) {
            System.out.println("\nEmail is empty");
            return null;
        }

        // Return null, if users list is empty
        if (users.isEmpty()) {
            System.out.println("List is empty. Register users to populate it");
            return null;
        }

        // Search by email
        for (var user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }

        return null;
    };

    public User register(User user) {
        if (user == null) {
            System.out.println("\nInvalid user. Received null");
            return null;
        }

        users.add(user);
        return null;
    };
}
