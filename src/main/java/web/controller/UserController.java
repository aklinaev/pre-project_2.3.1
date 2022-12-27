package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserDao userDAO;

    @Autowired
    public UserController(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("users", userDAO.getAll());
        return "showAll";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userDAO.getUser(id));
        return "showOne";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
//        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("user") User user) {
        userDAO.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userDAO.getUser(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable String id) {
        userDAO.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        userDAO.deleteUser(id);
        return "redirect:/users";
    }
}

