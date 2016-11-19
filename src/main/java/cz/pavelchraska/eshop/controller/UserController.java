package cz.pavelchraska.eshop.controller;


import cz.pavelchraska.eshop.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

@RequestMapping("/account")
    public String showAccount(Principal principal, Model model){
    String name=principal.getName();
    model.addAttribute("user",userDao.findByName(name));
    return "user-account";
}

}
