package ru.kurbanmagomedov.CRUD_security.util;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import ru.kurbanmagomedov.CRUD_security.models.Role;

import java.text.ParseException;
import java.util.Locale;

@Component
public class RoleFormatter implements Formatter<Role> {

    @Override
    public Role parse(String name, Locale locale) throws ParseException {
        Role role = new Role();
        role.setRole(name);
        return role;
    }

    @Override
    public String print(Role role, Locale locale) {
        String name = role.getRole();
        return name;
    }
}
