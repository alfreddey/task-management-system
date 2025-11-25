package models;

public class SoftwareProject extends Project {
    private String description;
    private int teamSize;
    private int budget;
    private ProjectType type;
    private Task[] tasks;

    public SoftwareProject(int id, String name, ProjectType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public SoftwareProject() {};

    public SoftwareProject(int id, String name) {
        this.id = id;
        this.name = name;
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

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public ProjectType getType() {
        return type;
    }

    public void setType(ProjectType type) {
        this.type = type;
    }
}
