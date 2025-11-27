package models;

import interfaces.Completable;

public class HardwareProject implements Completable {
    private String description;
    private int teamSize;
    private int budget;
    private int completionRate;
    private ProjectType type;
    private Task[] tasks;

    public boolean isCompleted() { return true; };
}
