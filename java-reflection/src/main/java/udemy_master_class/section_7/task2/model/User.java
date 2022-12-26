package udemy_master_class.section_7.task2.model;

import udemy_master_class.section_7.task2.enums.Role;

public class User {
    private final String name;
    private final Role role;

    public User(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }
}