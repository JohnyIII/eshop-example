package cz.pavelchraska.eshop.controller;


import cz.pavelchraska.eshop.dao.UserDao;
import cz.pavelchraska.eshop.dao.UserOrderDao;
import cz.pavelchraska.eshop.service.UserOrderService;
import cz.pavelchraska.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserOrderService userOrderService;

    @RequestMapping("/account")
    public String showAccount(Principal principal, Model model) {
        String name = principal.getName();
        model.addAttribute("user", userService.findByname(name));
        model.addAttribute("orders", userOrderService.findByUsername(name));
        return "user-account";
    }

}
