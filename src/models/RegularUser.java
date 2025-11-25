package models;

public class RegularUser extends User {
    private int[] taskIds;
    private int[] projectIds;
    private UserRole role = UserRole.REGULAR;

    public RegularUser(int id, String name, UserRole role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public RegularUser(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
