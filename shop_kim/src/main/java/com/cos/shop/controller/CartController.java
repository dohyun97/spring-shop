package com.cos.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.shop.config.auth.PrincipalDetail;
import com.cos.shop.service.CartService;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	
	@GetMapping("/cart")
	public String index(Model model,@AuthenticationPrincipal PrincipalDetail principal) {
		model.addAttribute("cart", cartService.cartList(principal.getUser()));
		return "cart/index";
	}
	
	@GetMapping("/cart/{cartId}/checkout/{totalPrice}")
	public String checkout(Model model, @PathVariable int cartId, @PathVariable int totalPrice,@AuthenticationPrincipal PrincipalDetail principal) {
		model.addAttribute("cartId", cartId);
		model.addAttribute("totalPrice", totalPrice);
		
		return "cart/checkout";
	}
}
