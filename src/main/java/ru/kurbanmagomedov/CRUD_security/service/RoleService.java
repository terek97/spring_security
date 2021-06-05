package ru.kurbanmagomedov.CRUD_security.service;

import ru.kurbanmagomedov.CRUD_security.models.Role;

import java.util.List;

public interface RoleService {
    Role getRoleById(Long id);

    Role getRoleByName(String name);

    List<Role> getAllRoles();
}
