package com.cos.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cos.shop.model.RoleType;
import com.cos.shop.model.User;
import com.cos.shop.repository.UserRepository;


@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder encoder;
	
	 @Transactional
     public void signUp(User user){
		
    	     String rawPassword = user.getPassword();
    	     String enPassword = encoder.encode(rawPassword);
    	     user.setPassword(enPassword);
    	     user.setRole(RoleType.USER);
    	     userRepository.save(user);
    	     
     }
	 @Transactional
     public void editUser(User user) {
    	   User persistance = userRepository.findById(user.getId()).orElseThrow(()->{
    		   return new IllegalArgumentException("Fail to find user");
    	   });
    	   String rawPassword = user.getPassword();
    	   String enPassword = encoder.encode(rawPassword);
    	   persistance.setPassword(enPassword);
    	   persistance.setEmail(user.getEmail());
     }
	 
	 //To signup as admin
//	 @Transactional
//     public void signUp(User user){
//    	     String rawPassword = user.getPassword();
//    	     String enPassword = encoder.encode(rawPassword);
//    	     user.setPassword(enPassword);
//    	     user.setRole(RoleType.ADMIN);
//    	     userRepository.save(user);
//    	     
//     }
}
