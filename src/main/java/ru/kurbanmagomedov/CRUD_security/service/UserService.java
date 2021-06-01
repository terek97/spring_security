package ru.kurbanmagomedov.CRUD_security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kurbanmagomedov.CRUD_security.models.Role;
import ru.kurbanmagomedov.CRUD_security.models.User;

import java.util.List;
import java.util.Set;

public interface UserService extends UserDetailsService {


    void saveUser(User user);

    User getUserById(Long id);

    public void setUser(User user, Set<Role> roles);

    void removeUser(Long id);

    List<User> getAllUsers();

    void addRole(User user, Role role);

    public User getUserByUsername(String username);
}
