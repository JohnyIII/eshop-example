package cz.pavelchraska.eshop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basket")
public class BasketController {

    @GetMapping
    public String getBasket(){
        return "basket";
    }

    @PostMapping
    public String order(Model model){
        return "basket";
    }

    @RequestMapping("/add")
    public String addItem(){
        return "redirect:/items.html";
    }
}
