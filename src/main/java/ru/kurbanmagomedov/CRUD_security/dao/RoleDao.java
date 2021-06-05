package ru.kurbanmagomedov.CRUD_security.dao;

import ru.kurbanmagomedov.CRUD_security.models.Role;

import java.util.List;

public interface RoleDao {

    Role getRoleById(Long id);

    List<Role> getAllRoles();

    Role getRoleByName(String name);

}
