package com.cos.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.shop.model.Cart;
import com.cos.shop.model.CartItem;
import com.cos.shop.model.Item;
import com.cos.shop.model.Review;
import com.cos.shop.model.User;
import com.cos.shop.repository.CartItemRepository;
import com.cos.shop.repository.CartRepository;
import com.cos.shop.repository.ItemRepository;
import com.cos.shop.repository.ReviewRepository;

@Service
public class ItemService {
   @Autowired
   private ItemRepository itemRepository;
   
   @Autowired
   private ReviewRepository reviewRepository;
   
   @Autowired
   private CartRepository cartRepository;
   
   @Autowired
   private CartItemRepository cartItemRepository;
   
   @Transactional
	public void upload(Item item, User user) {
		
		item.setUser(user);
		itemRepository.save(item);
	}
   
   @Transactional(readOnly=true)
	public Page<Item> writeList(Pageable pageable){
		return  itemRepository.findAll(pageable); 
	}
   @Transactional(readOnly=true)
	public Item details(int id) {
		return itemRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("Failed to find details");
		});
	}
   
   @Transactional
	public void updateItem(int id,Item requestItem) {
		Item item = itemRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("Failed to find item");
		});
		item.setAmount(requestItem.getAmount());
		item.setDetail(requestItem.getDetail());
		item.setName(requestItem.getName());
		item.setPrice(requestItem.getPrice());
		item.setStatus(requestItem.getStatus());
	}  
   
   @Transactional
	public void deleteItem(int id) {
		itemRepository.deleteById(id);
	}
   
   @Transactional
	public void writeReview(User user,int itemId, Review requestReview) {
		Item item = itemRepository.findById(itemId).orElseThrow(()->{
			return new IllegalArgumentException("Failed to find  ");
		});
		requestReview.setItem(item);
		requestReview.setUser(user);
		reviewRepository.save(requestReview);
	}
   @Transactional
	public void deleteReview(int reviewId) {
		reviewRepository.deleteById(reviewId); 
	}
   
  
@Transactional
   public void addCart(User user, int itemId, CartItem cartItem) {
	   Cart cart = cartRepository.findByUserId(user.getId()).orElse(new Cart());
	   Item item = itemRepository.findById(itemId).orElseThrow(()->{
 			return new IllegalArgumentException("Failed to find  ");
 		});
      CartItem cartitem = cartItemRepository.findByCartIdAndItemId(cart.getId(),item.getId()).orElse(new CartItem());

	   cart.setUser(user);
       cart.setAmount(cart.getAmount()+cartItem.getAmount());
       cartRepository.save(cart);
       

       cartitem.setAmount(cartItem.getAmount()+cartitem.getAmount());
       cartitem.setCart(cart);
       cartitem.setItem(item);
       cartItemRepository.save(cartitem);
	   
   }
	 
}
