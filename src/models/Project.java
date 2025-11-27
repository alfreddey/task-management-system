package models;

public abstract class Project {
    protected static int index;
    protected String name;

    public int getId() {
        return index;
    };

    public String getName() {
        return this.name;
    };

    public void setName(String name) {
        this.name = name;
    }
}
