package com.example.web.config;

import com.example.web.model.Role;
import com.example.web.model.User;
import com.example.web.service.RoleService;
import com.example.web.service.UserService;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataBaseInit {
    private final UserService userService;
    private final RoleService roleService;

    public DataBaseInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void startDB() {
        User admin = new User("admin", "Olga", "Kozlova", "gmail@mail.ru", "1234");
        Role userRole = new Role("ROLE_USER");
        Role adminRole = new Role("ROLE_ADMIN");
        Set<Role> superAdminRole = new HashSet<>();
        roleService.addRole(userRole);
        roleService.addRole(adminRole);
        admin.setOneRole(adminRole);
        userService.addUser(admin);
    }
}