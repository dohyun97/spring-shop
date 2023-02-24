package com.cos.shop.controller.api;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.shop.config.auth.PrincipalDetail;
import com.cos.shop.dto.ResponseDto;
import com.cos.shop.model.CartItem;
import com.cos.shop.model.OrderItem;
import com.cos.shop.model.Orders;
import com.cos.shop.repository.CartItemRepository;
import com.cos.shop.service.OrderService;
@RestController
public class OrderApiController {
    @Autowired
    private OrderService orderService;
    @Autowired 
    private CartItemRepository cartItemRepository;
	
	@PostMapping("/api/cart/{cartId}/checkout")
	public ResponseDto<String> orderSave(@Valid @PathVariable int cartId, @RequestBody Orders order, @AuthenticationPrincipal PrincipalDetail principal){
		ArrayList <CartItem> cartItems = cartItemRepository.findByCartId(cartId);

		for(CartItem cartItem : cartItems) {
			if(cartItem.getItem().getAmount() == 0 || cartItem.getItem().getAmount() < cartItem.getAmount()) {
				return new ResponseDto<String>(500,"Please choose quantity less than "+cartItem.getItem().getAmount());
				
			}
		}
		
		orderService.orderSave(cartId,order,principal.getUser());
		
		return new ResponseDto<String>(HttpStatus.OK.value(),""); 
	}
}
