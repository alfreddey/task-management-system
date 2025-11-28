import com.sun.security.jgss.GSSUtil;
import models.AdminUser;
import models.RegularUser;
import models.User;
import models.UserRole;
import services.UserService;
import test.ObjectCreationTest;
import test.TaskTest;
import java.util.Scanner;

import static utils.Util.colorString;
import static utils.Util.displayProjectTitle;

public class Main {
    public static void test() {
        ObjectCreationTest.createSoftwareProject();
        TaskTest.addTaskToProject();
    }

    public static void main(String[] args) {
        displayProjectTitle("JAVA PROJECT MANAGEMENT SYSTEM");

        // Sign-in user
        var userService = UserService.getService();
        System.out.println("Welcome, please Sign in to continue");
        System.out.print("Enter your email: ");
        Scanner scanner = new Scanner(System.in);
        String userEmail = scanner.next();
        var user = userService.signIn(userEmail);

        while (user == null) {
            System.out.println("\nError: Invalid email");
            System.out.printf("%s doesn't exist, sign in again or register a new email\n", colorString(userEmail));
            System.out.println("\nEnter S to sign in again or R to register this email");
            System.out.println("(enter Q to exit/quit)");

            // Prompt user
            System.out.print("Enter option here: ");
            var userOption = scanner.next();
            userOption = userOption.toUpperCase();

            if (userOption.equals("R")) {
                displayProjectTitle("User Registration Portal");
                System.out.println("Welcome, Let's create your account");
                String role;

                do {
                    System.out.print("Enter your role (R - Regular user, A - Admin user, q - to quit): ");
                    role = scanner.next();
                    role = role.toUpperCase();

                    // Create regular or admin user based on user input
                    if (role.equals("R")) {
                        user = new RegularUser();
                        user.setRole(UserRole.REGULAR);
                    } else if (role.equals("A")) {
                        user = new AdminUser();
                        user.setRole(UserRole.ADMIN);
                    } else if (role.equals("Q")){
                        System.out.println("Exiting program");
                    }
                } while ( // Repeat while user input is not (R, A, or Q)
                        !role.equals("R")
                        && !role.equals("A")
                        && !role.equals("Q")
                );

                // Prompt user to fill its details
                assert user != null;
                System.out.println("\nPlease enter your details below");
                System.out.print("Enter your name: ");
                scanner.nextLine();
                user.setName(scanner.nextLine());
                System.out.print("Enter your email: ");
                user.setEmail(scanner.next());

                // Add user to list of users
                user = userService.register(user);
                System.out.println("\nEmail registered successfully");
            } else if (userOption.equals("Q")) {
                System.exit(0);
            }

            System.out.print("\nEnter your email again: ");
            userEmail = scanner.next();
            user = userService.signIn(userEmail);
        }


        // Display current user's name
        System.out.printf("\nCurrent User: %s (%s)", user.getName(), user.getRole());
        // Display main menu items

        // Ask and read user's menu option/choice
    }
}