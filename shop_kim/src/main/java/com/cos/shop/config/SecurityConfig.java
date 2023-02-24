package com.cos.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.cos.shop.config.auth.PrincipalDetailsService;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig  {
	
	@Autowired
	private PrincipalDetailsService principalDetailService;
	
	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder(); 
	}
	
	
	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
		 auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	} 

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { 
		http
		  .csrf().disable()
		  .authorizeRequests()
		  	.antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**")
		  	.permitAll()
		  	.anyRequest()
		  	.authenticated()
		  .and()
		  	.formLogin()
		  	.loginPage("/auth/loginForm")
		  	.loginProcessingUrl("/auth/loginProc")
		  	.defaultSuccessUrl("/"); 
	    return http.build();
	    }
	

	
	
 }
