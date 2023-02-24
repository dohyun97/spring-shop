package com.cos.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.shop.model.Cart;
import com.cos.shop.model.CartItem;
import com.cos.shop.model.Item;
import com.cos.shop.model.User;
import com.cos.shop.repository.CartItemRepository;
import com.cos.shop.repository.CartRepository;
import com.cos.shop.repository.ItemRepository;

@Service
public class CartService {
	 @Autowired
	   private CartRepository cartRepository;
	 
	 @Autowired
	   private CartItemRepository cartItemRepository;
	 
	 @Autowired
	   private ItemRepository itemRepository;
	 
	 @Transactional(readOnly=true)
		public Cart cartList(User user){
			return cartRepository.findByUserId(user.getId()).orElse(new Cart());
			
			
		}
	 
	 @Transactional
		public void deleteItem(int id,int cartId) {
			
			Cart cart =cartRepository.findById(cartId).orElseThrow(()->{
				return new IllegalArgumentException("Failed to find  ");
			});
			CartItem cartItem = cartItemRepository.findById(id).orElseThrow(()->{
				return new IllegalArgumentException("Failed to find  ");
			});
		 
		int  amount=cartItem.getAmount();
		int totalAmount = (cart.getAmount())-amount;
		cart.setAmount(totalAmount);
		cartItemRepository.deleteById(id);
			
		}
	 
	 @Transactional(readOnly=true)
	 public int deletePrice(int id) {
		 CartItem cartItem = cartItemRepository.findById(id).orElseThrow(()->{
				return new IllegalArgumentException("Failed to find  ");
			});
		 
		int  amount=cartItem.getAmount();
		int itemId = cartItem.getId();
		Item item = itemRepository.findById(itemId).orElseThrow(()->{
			return new IllegalArgumentException("Failed to find  ");
		});
		int price = item.getPrice();
		int deletePrice = amount * price;
		return deletePrice;
	 }
	 
}
