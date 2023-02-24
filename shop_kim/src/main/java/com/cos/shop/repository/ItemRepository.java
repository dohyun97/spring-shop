package com.cos.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.shop.model.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>{

}
