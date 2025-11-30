package utils;

public class ValidationUtils {
    public static int getValidInt(String input, int min, int max) {
        try {
            int value = Integer.parseInt(input);

            if (value >= min && value <= max) {
                return value;
            } else {
                System.out.println("X Error: Input out of range. Must be between " + min + " and " + max + ".");
                return -1;
            }
        } catch (NumberFormatException e) {
            System.out.println("X Error: Invalid input. Please enter a valid number.");
            return -1;
        }
    }

    public static double getValidDouble(String input) {
        double value = Double.parseDouble(input);

        if (value >= 0) {
            return value;
        } else {
            return -1;
        }
    }
}
