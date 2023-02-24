package com.cos.shop.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.shop.dto.ResponseDto;
import com.cos.shop.service.CartService;

@RestController
public class CartApiController {
	
	@Autowired
	private CartService cartService;
	
	
	
	
	@DeleteMapping("/api/cart/{cartId}/item/{itemId}")
	public ResponseDto<Integer> cartItemDelete(@PathVariable int cartId,@PathVariable int itemId,Model model){
		cartService.deleteItem(itemId,cartId);
		model.addAttribute("deletePrice", cartService.deletePrice(itemId));
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);   
	}
	
	

}
