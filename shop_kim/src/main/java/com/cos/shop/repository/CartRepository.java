package com.cos.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.shop.model.Cart;


public interface CartRepository extends JpaRepository<Cart,Integer> {
	Optional<Cart> findByUserId(int userId);
}
