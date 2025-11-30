package models;

import java.util.Arrays;
import java.util.HashMap;

public abstract class Project {
    private static final int MAX_TASKS = 999;
    private static int index = 0;
    private int teamSize;
    private int taskCount;
    private double budget;
    private double completionRate;
    protected String id;
    protected String name;
    protected String description;
    private Task[] tasks;
    private ProjectType type;

    public Project(String name, String description, int teamSize, double budget, ProjectType type) {
        index += 1;
        this.id = String.format("P%03d", index);
        this.name = name;
        this.description = description;
        this.budget = budget;
        this.teamSize = teamSize;
        this.taskCount = 0;
        this.completionRate = 0;
        this.tasks = new Task[MAX_TASKS];
        this.type = type;
    }

    public abstract HashMap<String, String> getProjectDetails();

    public void displayProject() {

    }

    public void addTask(Task task) {
        if (taskCount >= MAX_TASKS - 1) {
            System.out.println("Task array is full");
            return;
        }

        tasks[taskCount++] = task;
    }

    public Task[] getTasks() {
        return Arrays.copyOf(tasks, taskCount);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getBudget() {
        return budget;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public double getCompletionRate() {
        int count = 0;
        for (Task task : tasks) {
            if (task == null)
                return 0;

            if (task.getStatus().equals(TaskStatus.COMPLETED)) {
                count++;
            }
        }
        return (count / taskCount) * 100;
    }

    public ProjectType getType() {
        return type;
    }
}