package cz.pavelchraska.eshop.controller;


import cz.pavelchraska.eshop.domain.Basket;
import cz.pavelchraska.eshop.entity.Item;
import cz.pavelchraska.eshop.entity.OrderedItem;
import cz.pavelchraska.eshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping("/basket")
@SessionAttributes("basket")
public class BasketController {

    @Autowired
    private ItemService itemService;

    @ModelAttribute("basket")
    public Basket construct() {
        return new Basket();
    }

    @GetMapping
    public String getBasket(Model model,HttpSession request) {
        Basket basket= (Basket) model.asMap().get("basket");
        Collection<OrderedItem> items=basket.getItems();
        int price=0;
        for(OrderedItem item : items){
            price+=(item.getItem().getPrice()*item.getQuantity());
        }
        model.addAttribute("total",price);
        return "basket";
    }

    @PostMapping
    public String order(Model model) {
        return "basket";
    }

    @RequestMapping(value = "/add")
    public String addItem(@RequestParam int id, @RequestParam int quantity, @ModelAttribute Basket basket) {
        basket.add(itemService.findById(id),quantity);
        return "redirect:/items.html";
    }
    @RequestMapping(value = "/remove")
    public String remove(@RequestParam int id, @ModelAttribute Basket basket){
        basket.remove(id);
        return "redirect:/basket.html";
    }
}
