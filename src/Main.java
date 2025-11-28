import models.AdminUser;
import models.RegularUser;
import models.UserRole;
import services.UserService;
import java.util.ArrayList;
import java.util.Scanner;
import static utils.Util.*;

public class Main {
    public static void main(String[] args) {
        // TODO: Seed users
        displayProjectTitle("SIGN IN / REGISTER");

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
                } while (
                        // Repeat while user input is not (R, A, or Q)
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

        // Create main menu items
        ArrayList<String> mainMenuList = new ArrayList<>();
        mainMenuList.add("Manage Projects");
        mainMenuList.add("Manage Tasks");
        mainMenuList.add("View Status Reports");
        mainMenuList.add("Switch Users");
        mainMenuList.add("Exit");

        // Display main menu title
        displayProjectTitle("JAVA TASK MANAGEMENT SYSTEM");
        System.out.printf("Current User: %s (%s)\n", user.getName(), user.getRole());

        // Display main menu items
        boolean running = true;
        do {
            displayMenus("Main Menu:", mainMenuList);
            System.out.print("Enter your choice: ");

            // Read and handle user input
            var option = scanner.nextInt();
            switch (option) {
                case 1:
                    // Manage projects
                    break;
                case 2:
                    // Manage tasks
                    break;
                case 3:
                    // View status reports
                    break;
                case 4:
                    // Switch user
                    break;
                case 5:
                    running = false;
                    System.out.println("Exited successfully");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.\n");
            }
        } while (running);

        scanner.close();
    }

    public static void manageProjectsMenu(Scanner scanner) {

    }

    public static void manageTasksMenu() {};

    public static void viewStatusReportsMenu() {};

    public static void switchUserMenu() {};
}