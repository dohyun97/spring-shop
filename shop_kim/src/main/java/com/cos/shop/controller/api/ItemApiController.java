package com.cos.shop.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cos.shop.config.auth.PrincipalDetail;
import com.cos.shop.dto.ResponseDto;
import com.cos.shop.model.CartItem;
import com.cos.shop.model.Item;
import com.cos.shop.model.Review;
import com.cos.shop.service.ItemService;



@RestController
public class ItemApiController {
	@Autowired
	private ItemService itemService;
	
	
	
	@PostMapping("/api/item")
	public ResponseDto<Integer> save(@Valid @RequestBody Item item,@AuthenticationPrincipal PrincipalDetail principal) {
		itemService.upload(item,principal.getUser()); 
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@PutMapping("/api/item/{id}")
	public ResponseDto<Integer> update(@Valid @PathVariable int id,@RequestBody Item item ){

		itemService.updateItem(id,item);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);   
	}
	@DeleteMapping("/api/item/{id}")
	public ResponseDto<Integer> deleteById(@PathVariable int id){
		itemService.deleteItem(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);   
	}
	@PostMapping("/api/item/{itemId}/review")
	public ResponseDto<Integer> reviewSave(@PathVariable int itemId,@RequestBody Review review,@AuthenticationPrincipal PrincipalDetail principal) {
		itemService.writeReview(principal.getUser(),itemId,review); 
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	@DeleteMapping("/api/item/{itemId}/review/{reviewId}")
	public ResponseDto<Integer> reviewDelete(@PathVariable int reviewId){
		itemService.deleteReview(reviewId);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);   
	}
	
	@PostMapping("/api/item/{itemId}/addcart")
	public ResponseDto<Integer> cartSave(@Valid @PathVariable int itemId,@RequestBody CartItem cartItem, @AuthenticationPrincipal PrincipalDetail principal){
		
		itemService.addCart(principal.getUser(),itemId, cartItem);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1); 
	}
}
