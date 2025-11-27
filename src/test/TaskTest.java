package test;

import models.SoftwareProject;
import models.Task;
import models.TaskStatus;

public class TaskTest {
    public static void addTaskToProject() {
        var tracker = new SoftwareProject("Alpha Tracker");
        var task = new Task(tracker.getId(), "Implement UI");

        System.out.println("\nAdd a new task");
        tracker.addTask(task);
        System.out.println(tracker);

        System.out.println("\nGet all tasks assigned to " + tracker.getName());
        System.out.printf(tracker.getAllTasks().toString());

        System.out.println("\nUpdate the status of a task");
        tracker.updateTaskStatus("TSK001", TaskStatus.COMPLETED);
        System.out.println(tracker);
    }
}
