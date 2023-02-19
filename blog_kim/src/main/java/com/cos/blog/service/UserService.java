package com.cos.blog.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

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
     //don't use when use spring security
    /*@Transactional(readOnly=true)
     public User logIn (User user){
    	 
    	    return  userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    	     
     } */
	
}
