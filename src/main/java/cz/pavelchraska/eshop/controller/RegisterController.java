package cz.pavelchraska.eshop.controller;


import cz.pavelchraska.eshop.dao.UserDao;
import cz.pavelchraska.eshop.entity.User;
import cz.pavelchraska.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserService userService;

    @ModelAttribute("user")
    public User constructUser() {
        return new User();
    }

    @GetMapping
    public String getRegister() {
        return "register";

    }

    @PostMapping
    public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if(result.hasErrors()){
            return "register";
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setEnabled(true);
        userService.save(user);
        return "redirect:/register.html?success=true";
    }
}
