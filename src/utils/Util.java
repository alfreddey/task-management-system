package utils;

import java.util.ArrayList;

public class Util {
    public static void displayProjectTitle(String title) {
        String line = "+" + "-".repeat(title.length() + 2) + "+";
        System.out.println("\n" + line);
        System.out.println("| " + title + " |");
        System.out.println(line + "\n");
    }

    public static String colorString(String str) {
        return "\u001B[33m" + str + "\u001B[0m";
    }

    public static void displayMenus(String heading, ArrayList<String> menus) {
        System.out.println("\n" + heading);
        System.out.println("-".repeat(heading.length()));
        for (int i = 0; i < menus.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, menus.get(i));
        }
    }
}
