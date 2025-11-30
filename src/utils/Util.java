package utils;

import java.util.ArrayList;

public class Util {
    public static void displayError(String message) {
        System.out.println("\n[ERROR]");
        System.out.println("----");
        System.out.println(message);
        System.out.println("----");
    }

    public static String colorString(String str) {
        return "\u001B[33m" + str + "\u001B[0m";
    }

    public static void displayMenu(String heading, ArrayList<String> menus) {
        System.out.println("\n" + heading);
        System.out.println("-".repeat(heading.length()));
        for (int i = 0; i < menus.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, menus.get(i));
        }
    }
}
