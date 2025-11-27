package models;

import interfaces.Completable;

public class Task implements Completable {
    private String id;
    private String name;
    private int projectId;
    protected static int index;
    protected TaskStatus status = TaskStatus.PENDING;

    public Task(int projectId, String name, TaskStatus status) {
        this.name = name;
        this.status = status;
        this.projectId = projectId;
    }

    public Task(int projectId, String name) {
        this.projectId = projectId;
        this.name = name;
    }

    public Task() {};

    @Override
    public String toString() {
        return String.format("Name: %s | Status: %s | ProjectID: %d", this.name, this.status, this.projectId);
    }

    // Getters
    public String getId() {
        return id;
    }

    public void getStatus() {};


    // Setters
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    // Interface methods
    public boolean isCompleted() {
        return this.status == TaskStatus.COMPLETED;
    };
}
