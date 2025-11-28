package models;

public class AdminUser extends User {
    private final UserRole role = UserRole.ADMIN;

    public AdminUser(String name) {
        index = index + 1;
        this.name = name;
    };

    public AdminUser() {
        index = index + 1;
    }

    public UserRole getRole() {
        return role;
    }
}
