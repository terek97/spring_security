package ru.kurbanmagomedov.CRUD_security.controllers;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import ru.kurbanmagomedov.CRUD_security.dao.RoleDao;
import ru.kurbanmagomedov.CRUD_security.models.Role;
import ru.kurbanmagomedov.CRUD_security.models.User;
import ru.kurbanmagomedov.CRUD_security.service.RoleService;
import ru.kurbanmagomedov.CRUD_security.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping("users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/users/new")
    public String  newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @GetMapping("/user/{id}")
    public String getUserByID(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("role", roleService.getRoleById(2L));
//        model.addAttribute("userRoles", userService.getUserById(id).getRoles());
        model.addAttribute("allRoles", roleService.getAllRoles());

        return "one_user";
    }

    @PostMapping("/user/new")
    public RedirectView createUser(@ModelAttribute("user") User user) {
        userService.addRole(user, roleService.getRoleById(1L));
        userService.saveUser(user);
        return new RedirectView("/admin/users");
    }

    @PatchMapping("/user/change")
    public RedirectView changeUser(@ModelAttribute("user") User user) {
        userService.setUser(user);
        return new RedirectView("/admin/users");
    }

    @DeleteMapping("/user/{id}")
    public RedirectView removeUser(@PathVariable("id") Long id) {
//        System.out.println(user.getId());
        userService.removeUser(id);
        return new RedirectView("/admin/users");
    }
}
