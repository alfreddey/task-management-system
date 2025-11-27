import models.RegularUser;
import models.SoftwareProject;
import test.ObjectCreationTest;
import test.TaskTest;
import utils.ConsoleMenu;

public class Main {
    public static void test() {
        ObjectCreationTest.createSoftwareProject();
        TaskTest.addTaskToProject();
    }

    public static void main(String[] args) {
        test();

    }
}