package ru.eugenekirillov.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.eugenekirillov.boot.model.User;
import ru.eugenekirillov.boot.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/users", "/"})
    public String listAll(ModelMap model) {
        model.addAttribute("users", userService.list());
        return "users";
    }

    @GetMapping(value = "/user")
    public String edit(@RequestParam(value = "id", required = false) long id, ModelMap model) {
        model.addAttribute("user", userService.get(id));
        return "user";
    }

    //здесь же происходит добавление юзера (юзер с нулевым id)
    @PostMapping(value = "/user")
    public String edit(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/add")
    public String add(ModelMap model) {
        model.addAttribute("user", new User());
        return "user";
    }

}
