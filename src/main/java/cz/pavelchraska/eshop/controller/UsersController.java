package cz.pavelchraska.eshop.controller;

import cz.pavelchraska.eshop.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", usersService.getAllUsers());
        return "users";
    }

}
