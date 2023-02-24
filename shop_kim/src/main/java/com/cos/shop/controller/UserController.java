package com.cos.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    
    @GetMapping("/auth/signupForm")
	public String signupForm() {
		return "user/signupForm";
	} 
    @GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
	} 
    @GetMapping("/user/updateForm")
	public String updateForm()  {
		return "user/updateForm";
	} 
}
