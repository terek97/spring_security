package ru.kurbanmagomedov.CRUD_security.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kurbanmagomedov.CRUD_security.models.User;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String getUser(@AuthenticationPrincipal User user, Model model) {
        List<User> users = new ArrayList<>();
        users.add(user);
        model.addAttribute("users", users);
        return "users";
    }
}
