package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;
import web.service.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("users", userService.getAll());
        return "showAll";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "showOne";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable String id) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}

