package com.cos.shop.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.shop.model.User;
import com.cos.shop.repository.UserRepository;


@Service
public class PrincipalDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User principal = userRepository.findByUsername(username).orElseThrow(()->{
			return new UsernameNotFoundException("Username doesn't exist:" +username);
		});
		return new PrincipalDetail(principal);
	}
	 

}
