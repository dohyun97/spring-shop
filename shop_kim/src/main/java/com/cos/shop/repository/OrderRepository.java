package com.cos.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.shop.model.Orders;

public interface OrderRepository extends JpaRepository<Orders,Integer>{
//  Optional<Orders> findByCartId(int cartId);
}
