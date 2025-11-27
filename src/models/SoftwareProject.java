package models;

import java.util.ArrayList;

public class SoftwareProject extends Project {
    private String id;
    private String description;
    private int teamSize;
    private int budget;
    private int completionRate;
    private ProjectType type;
    private ArrayList<Task> tasks;

    public SoftwareProject(String name, ProjectType type) {
        index = index + 1;
        this.id = String.format("P%03d", index);
        this.name = name;
        this.type = type;
        this.tasks = new ArrayList<>();
    }

    public SoftwareProject() {};

    public SoftwareProject(String name) {
        index = index + 1;
        this.name = name;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public Task getTask(String taskId) {
        for (Task task : tasks) {
            if (taskId.equals(task.getId())) {
                return task;
            }
        }
        return new Task();
    }

    public ArrayList<Task> getAllTasks() {
        return this.tasks;
    }

    public void updateTaskStatus(Task task) {

    }

    // Getters
    public String getDescription() {
        return description;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public int getBudget() {
        return budget;
    }

    public ProjectType getType() {
        return type;
    }

    public int getCompletionRate() {
        return completionRate;
    }

    // Setters
    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public void setType(ProjectType type) {
        this.type = type;
    }

    public void setCompletionRate(int completionRate) {
        this.completionRate = completionRate;
    }
}
