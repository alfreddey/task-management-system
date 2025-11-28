package models;

public class RegularUser extends User {
    private int[] taskIds;
    private int[] projectIds;
    private final UserRole role = UserRole.REGULAR;

    public RegularUser(String name) {
        index = index + 1;
        this.name = name;
    }



    public RegularUser() {
        index = index + 1;
    }

    public UserRole getRole() {
        return role;
    }
}
