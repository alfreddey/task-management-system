package models;

import java.util.ArrayList;
import java.util.HashMap;

public class SoftwareProject extends Project {
    private final ProjectType type = ProjectType.SOFTWARE;
    private String id;
    private String description;
    private int teamSize;
    private int budget;
    private int completionRate;
    private ArrayList<Task> tasks;

    // Constructors
    public SoftwareProject(String name) {
        index = index + 1;
        this.id = String.format("P%03d", index);
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public SoftwareProject() {};

    // Methods
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void updateTaskStatus(String taskId, TaskStatus status) {
        var task = getTask(taskId);
        if (task.exists()) {
            task.setStatus(status);
            return;
        }

        System.out.println("Task not found");
    }

    // TODO: COMPLETE AND TEST THIS
    public HashMap<Object, Object> getProjectDetails() {
        var projectDetails = new HashMap<>();
        projectDetails.put("Id", this.name);
        projectDetails.put("Name", this.name);
        projectDetails.put("Description", this.name);
        
        return projectDetails;
    }

    // Helper functions
    public Task getTask(String taskId) {
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                return task;
            }
        }

        return new Task();
    }

    public ArrayList<Task> getAllTasks() {
        return this.tasks;
    }

    @Override
    public String toString() {
        return String.format(
                "Name: %s,\nType: %s\nID: %s,\nTasks: %s",
                this.name,
                this.type,
                this.id,
                this.tasks.toString()
        );
    }

    // Getters
    public String getId() {
        return id;
    }

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

    public void setCompletionRate(int completionRate) {
        this.completionRate = completionRate;
    }
}
