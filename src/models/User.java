package models;

public abstract class User {
    protected static int index;
    protected String email;   // Required field
    protected String name;
    protected UserRole role;

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return index;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
