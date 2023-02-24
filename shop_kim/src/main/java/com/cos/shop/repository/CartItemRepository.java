package com.cos.shop.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.shop.model.CartItem;


public interface CartItemRepository extends JpaRepository<CartItem,Integer>{
	Optional<CartItem> findByCartIdAndItemId(int cartId,int itemId);
	ArrayList<CartItem> findByCartId(int cartId);
	
}
