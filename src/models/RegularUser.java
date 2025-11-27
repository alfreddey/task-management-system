package models;

public class RegularUser extends User {
    private int[] taskIds;
    private int[] projectIds;
    private final UserRole role = UserRole.REGULAR;

    public RegularUser(int id, String name) {
        index = index + 1;
        this.name = name;
    }

    public UserRole getRole() {
        return role;
    }
}
