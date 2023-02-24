package com.cos.shop.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ControllerTest {
	 @GetMapping("/t/shop")
	    public String Test() {
	    	return "Get request!";
	 }
}
