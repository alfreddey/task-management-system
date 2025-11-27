package models;

public class AdminUser extends User {
    private final UserRole role = UserRole.ADMIN;

    public AdminUser(int id, String name) {
        index = index + 1;
        this.name = name;
    };

    public UserRole getRole() {
        return role;
    }
}
