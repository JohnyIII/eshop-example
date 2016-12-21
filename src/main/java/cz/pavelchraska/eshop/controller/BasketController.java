package cz.pavelchraska.eshop.controller;


import cz.pavelchraska.eshop.domain.Basket;
import cz.pavelchraska.eshop.entity.UserOrder;
import cz.pavelchraska.eshop.entity.OrderedItem;
import cz.pavelchraska.eshop.service.ItemService;
import cz.pavelchraska.eshop.service.UserOrderService;
import cz.pavelchraska.eshop.service.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("/basket")
@SessionAttributes("basket")
public class BasketController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;
    @Autowired
    private UserOrderService userOrderService;

    @ModelAttribute("basket")
    public Basket construct() {
        return new Basket();
    }

    @ModelAttribute("userOrder")
    public UserOrder create() {
        return new UserOrder();
    }

    @GetMapping
    public String getBasket(Model model, HttpSession request) {

        model.addAttribute("total", countTotalPrice(model));
        return "basket";
    }

    @PostMapping
    public String order(@Valid @ModelAttribute UserOrder userOrder, BindingResult result, Principal principal, @ModelAttribute Basket basket) {
        if(result.hasErrors()){
            return "basket";
        }
        userOrder.setUser(userService.findByName(principal.getName()));
        ArrayList<OrderedItem> list=new ArrayList<OrderedItem>(basket.getItems());
        for (OrderedItem orderedItem : list) {
			orderedItem.setUserOrder(userOrder);
		}
        userOrder.setOrderedItems(list);
        
        userOrderService.save(userOrder);
   
        basket.clear();
        return "redirect:/account.html";
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
