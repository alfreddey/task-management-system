package test;

import models.ProjectType;
import models.SoftwareProject;
import models.Task;
import models.TaskStatus;

public class ObjectCreationTest {
    public static void createSoftwareProject() {
        var mypr = new SoftwareProject("Hello");
        System.out.println(mypr.getName());
        System.out.println(mypr.getId());
    }
}
