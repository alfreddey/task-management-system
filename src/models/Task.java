package models;

import interfaces.Completable;

import java.util.Date;

public class Task implements Completable {
    protected static int index;
    private TaskStatus status = TaskStatus.PENDING;
    private String id;
    private String name;
    private String projectId;
    private Date hour;

    // Constructors
    public Task(String projectId) {
        index = index + 1;
        this.id = String.format("TSK%03d", index);
        this.projectId = projectId;
    }

    public Task(String projectId, String name) {
        index = index + 1;
        this.id = String.format("TSK%03d", index);
        this.projectId = projectId;
        this.name = name;
    }

    public Task() {};


    // Helper functions
    @Override
    public String toString() {
        return String.format(
                "\n\tID: %s\n\tName: %s\n\tStatus: %s\n\tProjectID: %s\n",
                this.id,
                this.name,
                this.status,
                this.projectId
        );
    }

    public boolean exists() {
        return !id.isEmpty();
    }


    // Getters
    public String getId() {
        return id;
    }

    public TaskStatus getStatus() {
        return status;
    };


    // Setters
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }


    // Interface methods
    public boolean isCompleted() {
        return this.status == TaskStatus.COMPLETED;
    };
}
