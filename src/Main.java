import java.util.ArrayList;
import java.util.Scanner;

import models.AdminUser;
import models.HardwareProject;
import models.Project;
import models.ProjectType;
import models.RegularUser;
import models.SoftwareProject;
import models.TaskStatus;
import models.User;
import models.UserRole;
import services.ProjectService;
import services.UserService;
import utils.ConsoleMenu;
import utils.Util;
import utils.ValidationUtils;

public class Main {
    private static UserService userService = UserService.getService();
    private static ProjectService projectService = ProjectService.getService();
    private static User user;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Seed database
        seedDatabase();

        // Display app menu
        boolean running = true;
        do {
            ConsoleMenu.displayTitle("JAVA TASK MANAGEMENT SYSTEM");
            System.out.println("Welcome, Enter S to sign in, R to register or Q to quit the program");
            System.out.print("Enter your choice: ");
            String option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "S":
                    signInUser(scanner);
                    break;
                case "R":
                    registerUser(scanner);
                    break;
                case "Q":
                    running = false;
                    break;
                default:
                    ConsoleMenu.clearConsole();
                    System.out.println("\nInvalid input. Please try again.");
            }
        } while (running);

        scanner.close();
    }

    public static void seedDatabase() {
        userService.createUser(new RegularUser("alfred", "null"));
        userService.createUser(new RegularUser("oun", "nu1l"));
        userService.createUser(new RegularUser("yun", "nu2l"));

        userService.createUser(new AdminUser("alfred", "s"));

        projectService.addProject(new SoftwareProject("sdfa", "'something'", 23, 23));
    };

    public static void signInUser(Scanner scanner) {
        boolean signedIn = false;
        do {
            ConsoleMenu.displayTitle("SIGN IN PORTAL");
            System.out.print("Welcome, Enter your email here: ");
            String email = scanner.nextLine();
            user = userService.findUserByEmail(email);

            if (user == null) {
                Util.displayError("Invalid User");
                System.out.println("Please try again");
            } else {
                displayMainMenu(scanner);
                signedIn = true;
            }
        } while (!signedIn);
    };

    public static void displayMainMenu(Scanner scanner) {
        boolean running = true;
        do {
            ConsoleMenu.displayTitle("JAVA TASK MANAGEMENT SYSTEM");
            System.out.printf("Current User: %s (%s)\n", user.getName(), user.getRole());

            ConsoleMenu.displayMainMenu(); // Choice ranges from 1 - 5
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            int choice = ValidationUtils.getValidInt(input, 1, 5);

            switch (choice) {
                case 1:
                    manageProjectMenu(scanner);
                    break;
                case 2:
                    manageTaskMenu(scanner);
                    break;
                case 3:
                    viewStatusReports();
                    break;
                case 4:
                    switchUser();
                    break;
                case 5:
                    running = false;
                    break;
            }
        } while (running);
    }

    public static void manageProjectMenu(Scanner scanner) {
        boolean exit = false;
        do {
            ConsoleMenu.displayTitle("PROJECT MANAGEMENT MENU");
            ConsoleMenu.displayManageProjectMenu(); // Choice ranges from 1 - 3
            System.out.println("Enter your choice: ");
            String input = scanner.nextLine();
            int choice = ValidationUtils.getValidInt(input, 1, 3);

            switch (choice) {
                case 1:
                    createNewProject(scanner);
                    break;
                case 2:
                    viewProjectCatalog(scanner);
                    break;
                case 3:
                    exit = true;
                    break;
            }
        } while (!exit);
    };

    public static void createNewProject(Scanner scanner) {
        if (user.getRole() != UserRole.ADMIN) {
            System.out.println("Access denied. Only Admins can create projects");
            return;
        }

        // displays title, and subtitle
        ConsoleMenu.displayNewProjectMenu();

        // Fill out project details
        System.out.print("Enter project name: ");
        String name = scanner.nextLine();

        System.out.print("Enter budget amount: ");
        String budgetInput = scanner.nextLine();
        double budget = ValidationUtils.getValidDouble(budgetInput);

        System.out.print("Enter team size (>=1): ");
        String input = scanner.nextLine();
        int teamSize = ValidationUtils.getValidInt(input, 1, Integer.MAX_VALUE);
        if (teamSize < 0)
            return;

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter the project type(SOFTWARE (S) /HARDWARE (H)): ");
        String type = scanner.nextLine().toUpperCase();

        Project project = null;

        switch (type) {
            case "S":
                project = new SoftwareProject(name, description, teamSize, budget);
                break;
            case "H":
                project = new HardwareProject(name, description, teamSize, budget);
                // TODO: Add material cost
                break;
            default:
                System.out.println("Project type must be either HARDWARE OR SOFTWARE");
                return;
        }

        projectService.addProject(project);
        System.out.println("Project added successfully");
    }

    public static void viewProjectCatalog(Scanner scanner) {
        ConsoleMenu.displayTitle("PROJECT CATALOG");
        System.out.println("Filter Options:");
        System.out.printf("1. View all projects (%d)\n", projectService.getProjectCount());
        System.out.println("2. Software projects only");
        System.out.println("3. Hardware projects only");
        System.out.println("4. Search by budget range");
        System.out.print("Enter filter choice: ");
        String input = scanner.nextLine();
        int choice = ValidationUtils.getValidInt(input, 1, 4);

        switch (choice) {
            case 1:
                viewAllProjects(scanner);
                break;
            case 2:
                viewProjectByType(ProjectType.SOFTWARE);
                break;
            case 3:
                viewProjectByType(ProjectType.HARDWARE);
                break;
            case 4:
                searchByBudgetRange();
                break;
        }
    }

    public static void viewAllProjects(Scanner scanner) {
        // projectService.displayAllProjects();
        System.out.print("Enter project ID to view details (or 0 to return): ");
        String input = scanner.nextLine();

        if (input == "0") {
            return;
        }

        // TODO: Check if input has the pattern P001. [Regex]

        Project project = projectService.getProjectById(input);
        displayProjectDetails(project, scanner);
    }

    public static void displayProjectDetails(Project project, Scanner scanner) {
        ConsoleMenu.displayTitle(String.format("PROJECT DETAILS: %s", project.getId()));

        projectService.displayProjectDestails(project);

        project.displayTasks();

        System.out.printf("Completion Rate: %.2f%%", project.getCompletionRate());

        ArrayList<String> menuItems = new ArrayList<>();
        menuItems.add("Add new task");
        menuItems.add("Update task status");
        menuItems.add("Remove task");
        menuItems.add("Back to Main Menu");
        Util.displayMenu("Options", menuItems);

        System.out.print("Enter your choice: ");
        String input = scanner.nextLine();
        int option = ValidationUtils.getValidInt(input, 1, 4);

        switch (option) {
            case 1:
                addNewTask(scanner, project);
                break;
            case 2:
                updateTaskStatus();
                break;
            case 3:
                removeTask();
                break;
            case 4:
                return;
        }
    }

    public static void addNewTask(Scanner scanner, Project project) {
        ConsoleMenu.displayTitle("ADD NEW TASK");

        System.out.print("Enter task name: ");
        String taskName = scanner.nextLine();

        System.out.print("Enter assigned project ID: ");
        String projectId = scanner.nextLine();

        boolean done = false;
        do {
            System.out.print("Enter initial status (Pending (P) /In Progress (I) /Completed (C)): ");
            String input = scanner.nextLine();
            TaskStatus projectType;

            switch (input) {
                case "P":
                    projectType = TaskStatus.PENDING;
                    done = true;
                    break;
                case "I":
                    projectType = TaskStatus.IN_PROGRESS;
                    done = true;
                    break;
                case "C":
                    projectType = TaskStatus.COMPLETED;
                    done = true;
                    break;
                default:
                    System.out.println("Please try again");
            }
        } while (!done);

        System.out.printf("Task '%s' added successfully to Project %s", taskName, project.getId());
    }

    public static void manageTaskMenu(Scanner scanner) {
    };

    public static void viewStatusReports() {
    };

    public static void switchUser() {
    };

    public static void registerUser(Scanner scanner) {

    }
}