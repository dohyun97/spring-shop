package com.cos.shop.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.shop.config.auth.PrincipalDetail;
import com.cos.shop.dto.ResponseDto;
import com.cos.shop.model.User;
import com.cos.shop.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/signupProc")
	public ResponseDto<Integer> save(@Valid @RequestBody User user ,@AuthenticationPrincipal PrincipalDetail principal) {
	   
		userService.signUp(user);
	   
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	
	}
	@PutMapping("/user")
	public ResponseDto<Integer> update(@Valid @RequestBody User user){
		userService.editUser(user);
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);  
	
	}
	
}
