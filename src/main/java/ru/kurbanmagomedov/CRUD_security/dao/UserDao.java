package ru.kurbanmagomedov.CRUD_security.dao;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.kurbanmagomedov.CRUD_security.models.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    User getUserById(Long id);

    void setUser(User user);

    void removeUser(Long id);

    List<User> getAllUsers();

    public User loadUserByUsername(String s) throws UsernameNotFoundException;
}
