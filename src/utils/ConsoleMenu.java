package utils;

import models.UserRole;

import java.util.ArrayList;

public class ConsoleMenu {
    public static void displayMainMenu() {
        var menuItems = new ArrayList<>();
        menuItems.add("Manage Projects");
        menuItems.add("Manage Tasks");
        menuItems.add("View Status Reports");
        menuItems.add("Switch Users");
        menuItems.add("Exit");

        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, menuItems.get(i));
        }
    }

    public static void displayProductCatalog() {};
}
