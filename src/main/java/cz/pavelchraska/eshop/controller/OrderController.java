package cz.pavelchraska.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.pavelchraska.eshop.service.UserOrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private UserOrderService userOrderService;
	
	@GetMapping("{id}")
	public String getOrder(@PathVariable int id, Model model){
		model.addAttribute("order", userOrderService.findByIdWithItems(id));
		return "order";
	}

}
