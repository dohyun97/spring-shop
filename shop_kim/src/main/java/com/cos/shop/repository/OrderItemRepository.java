package com.cos.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.shop.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {

}
