 package com.cos.blog.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class ControllerTest {
	
	 @Autowired
     private UserRepository userRepository;
	 
	 //select * from user
	 @GetMapping("dummy/users")
	 public List<User> list(){
		 
		 return userRepository.findAll();
	 }
	 
	 //get two datas per page
	 //http://localhost:8000/blog/dummy/user?page=1
	 @GetMapping("dummy/user")
	 public List<User> pageList(@PageableDefault(size=2, sort="id",direction = Sort.Direction.DESC)Pageable pageable){
		 Page<User> pagingUser = userRepository.findAll(pageable);
		 List<User> users = pagingUser.getContent();
		 return users;  
	 }
	 
	 //Update user by id
	 @Transactional
	 @PutMapping("/dummy/user/{id}")
	 public User updateUser(@PathVariable int id , @RequestBody User requestUser) {
		 System.out.println("Id: "+id);
		 System.out.println("password: "+requestUser.getPassword());
		 System.out.println("email: "+requestUser.getEmail());
		 
		 User user = userRepository.findById(id).orElseThrow(()->{
			 return new IllegalArgumentException("Unavailabe id");
		 });
		 user.setEmail(requestUser.getEmail());
		 user.setPassword(requestUser.getPassword());
		 //userRepository.save(user);
		 return user;
	 }
	 
	 //Delete
	 @DeleteMapping("/dummy/user/{id}")
	 public String delete(@PathVariable int id) {
	   try {
		   userRepository.deleteById(id);
	   }catch(EmptyResultDataAccessException e) {
		   return "No id:"+id+" exist";
	   }
		 return id+" has deleted";
	 }
	 
	 //select user by id
	 @GetMapping("dummy/user/{id}")
	 public User detail(@PathVariable int id){
		 User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {

			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("No user for id: "+id);
			}
			 
		 });
		 return user;
	 }
     
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("id: "+user.getId());
		System.out.println("password: "+user.getPassword());
		System.out.println("username: "+user.getUsername());
		System.out.println("email: "+user.getEmail());
		System.out.println("role: "+user.getRole());
		System.out.println("createDate: "+user.getCreateDate());
		
		user.setRole(RoleType.USER);//Default value is "USER"
		userRepository.save(user);//Insert user
		return "Sucess";
		
	}
	@GetMapping("/test")
	public String test() {
		return "<h1>get</h1>";
	}

}
