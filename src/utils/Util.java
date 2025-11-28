package utils;

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
}
