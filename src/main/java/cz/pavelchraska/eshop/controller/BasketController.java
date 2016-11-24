package cz.pavelchraska.eshop.controller;


import cz.pavelchraska.eshop.domain.Basket;
import cz.pavelchraska.eshop.entity.Order;
import cz.pavelchraska.eshop.entity.OrderedItem;
import cz.pavelchraska.eshop.service.ItemService;
import cz.pavelchraska.eshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
@RequestMapping("/basket")
@SessionAttributes("basket")
public class BasketController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderService orderService;

    @ModelAttribute("basket")
    public Basket construct() {
        return new Basket();
    }

    @ModelAttribute("order")
    public Order create() {
        return new Order();
    }

    @GetMapping
    public String getBasket(Model model, HttpSession request) {

        model.addAttribute("total", countTotalPrice(model));
        return "basket";
    }

    @PostMapping
    public String order(Model model) {
        System.out.println(model.toString());
        System.out.println(model.containsAttribute("order"));
    orderService.order();
        model.addAttribute("aa","You tried to order");
        return "basket";
    }

    @RequestMapping(value = "/add")
    public String addItem(@RequestParam int id, @RequestParam int quantity, @ModelAttribute Basket basket) {
        basket.add(itemService.findById(id), quantity);
        return "redirect:/items.html";
    }

    @RequestMapping(value = "/remove")
    public String remove(@RequestParam int id, @ModelAttribute Basket basket) {
        basket.remove(id);
        return "redirect:/basket.html";
    }

    private Integer countTotalPrice(Model model) {
        Basket basket = (Basket) model.asMap().get("basket");
        Collection<OrderedItem> items = basket.getItems();
        Integer price = 0;
        for (OrderedItem item : items) {
            price += (item.getItem().getPrice() * item.getQuantity());
        }
        return price;

    }
}
