package cz.pavelchraska.eshop.controller;


import cz.pavelchraska.eshop.dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemDao itemDao;

    @GetMapping
    public String viewItems(Model model) {
        model.addAttribute("items",itemDao.findAll());
        return "items";
    }
}
