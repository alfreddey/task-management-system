package models;

public abstract class Project {
    protected int id;
    protected String name;

    public int getId() {
        return this.id;
    };

    public String getName() {
        return this.name;
    };

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
