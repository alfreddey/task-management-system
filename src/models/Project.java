package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public abstract class Project {
    protected static int index;
    protected String id;
    protected String name;
    protected String description;
    protected int budget;
    protected int teamSize;

    public abstract HashMap<Object, Object> getProjectDetails();

    // TODO: TEST THIS
    public void displayProject() {
        System.out.printf(
                "\nID: %s\nName: %s\nDescription: %s\nBudget: %d\nTeamSize: %d\n",
                this.id,
                this.name,
                this.description,
                this.budget,
                this.teamSize
        );
    }

    // Getters
    protected int getIndex() {
        return index;
    };

    public String getName() {
        return this.name;
    };


    // Setters
    public void setName(String name) {
        this.name = name;
    }
}
