package utils;

import models.UserRole;

import java.util.ArrayList;

public class ConsoleMenu {
    public static void displayTitle(String title) {
        String line = "+" + "-".repeat(title.length() + 2) + "+";
        System.out.println("\n" + line);
        System.out.println("| " + title + " |");
        System.out.println(line + "\n");
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (final Exception e) {
            System.out.println("Error attempting to clear the console");
            e.printStackTrace();
        }
    }

    public static void displayManageProjectMenu() {
        ArrayList<String> manageProjectMenu = new ArrayList<>();
        manageProjectMenu.add("Create New Project");
        manageProjectMenu.add("View Project Catalog");
        manageProjectMenu.add("Back to Main Menu");

        Util.displayMenu("Project Management Menu", manageProjectMenu);
    }

    public static void displayNewProjectMenu() {
        displayTitle("Create a new Project");
        System.out.println("Enter the project details below to create a new one");
    }

    public static void displayMainMenu() {
        ArrayList<String> mainMenuList = new ArrayList<>();
        mainMenuList.add("Manage Projects");
        mainMenuList.add("Manage Tasks");
        mainMenuList.add("View Status Reports");
        mainMenuList.add("Switch User");
        mainMenuList.add("Exit");

        Util.displayMenu("Main Menu", mainMenuList);
    }
}
