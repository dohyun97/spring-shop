package com.cos.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.shop.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired 
	private OrderService orderService;
   
	@GetMapping("/orderStatus")
	public String status(Model model,@PageableDefault(size=25, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("orders", orderService.orderDetails(pageable));
		return "/order/detail";
	}
}
