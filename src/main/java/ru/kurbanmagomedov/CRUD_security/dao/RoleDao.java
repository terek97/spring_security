package ru.kurbanmagomedov.CRUD_security.dao;

import ru.kurbanmagomedov.CRUD_security.models.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {

    Role getRoleById(Long id);

    List<Role> getAllRoles();

    public Role getRoleByName(String name);

}
