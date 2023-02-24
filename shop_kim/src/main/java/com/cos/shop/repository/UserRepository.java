package com.cos.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.shop.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	Optional<User> findByUsername(String username);
	 
	
}

