package com.cos.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.shop.model.CartItem;
import com.cos.shop.model.Item;
import com.cos.shop.model.OrderItem;
import com.cos.shop.model.Orders;
import com.cos.shop.model.SellStatus;
import com.cos.shop.model.User;
import com.cos.shop.repository.CartItemRepository;
import com.cos.shop.repository.CartRepository;
import com.cos.shop.repository.ItemRepository;
import com.cos.shop.repository.OrderItemRepository;
import com.cos.shop.repository.OrderRepository;

@Service
public class OrderService {
  @Autowired 
  private OrderRepository orderRepository;
  
  @Autowired
  private OrderItemRepository orderItemRepository;
  
  @Autowired 
  private CartItemRepository cartItemRepository;
  
  @Autowired 
  private CartRepository cartRepository;
  
  @Autowired
  private ItemRepository itemRepository;
  
  @Transactional
  public void orderSave(int cartId, Orders order,User user) {
	  
	  order.setUser(user);
	  orderRepository.save(order);
	  
	  ArrayList <CartItem> cartItems = cartItemRepository.findByCartId(cartId);
	  
	  for(CartItem cartItem : cartItems) {
		  OrderItem orderItem = new OrderItem();
		 Item item = itemRepository.findById(cartItem.getItem().getId()).orElseThrow(()->{
				return new IllegalArgumentException("Failed to find item");
			});
	      orderItem.setItem(cartItem.getItem());
	      orderItem.setAmount(cartItem.getAmount());
		  orderItem.setOrder(order);
		  orderItemRepository.save(orderItem);
		  item.setAmount(item.getAmount()-cartItem.getAmount());
		  if(item.getAmount() == 0) {
			  item.setStatus(SellStatus.UNAVAILABLE);
		  }
		  itemRepository.save(item);
		}
	 
	  cartRepository.deleteById(cartId);
	  

  }
  @Transactional(readOnly=true)
	public Page<Orders> orderDetails(Pageable pageable){
		return  orderRepository.findAll(pageable); 
	}
  
  
}
