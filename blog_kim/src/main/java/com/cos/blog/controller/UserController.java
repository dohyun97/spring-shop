package com.cos.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.blog.config.auth.PrincipalDetail;


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
