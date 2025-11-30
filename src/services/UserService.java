package services;

import models.User;

public class UserService {
    private static UserService service;
    private final int MAX_USERS = 999;
    private int userCount;
    private User[] users;

    private UserService() {
        this.users = new User[MAX_USERS];
        this.userCount = 0;
    }

    public static UserService getService() {
        if (service == null) {
            service = new UserService();
        }

        return service;
    }

    public void createUser(User user) {
        if (userCount >= MAX_USERS - 1) {
            System.out.println("User array is full");
            return;
        }

        users[userCount++] = user;
    }

    public User findUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }

        return null;
    }
}
