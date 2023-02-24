package com.cos.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.shop.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/item/uploadForm")
	public String saveForm() {
		return "item/uploadForm";
	}
	
	@GetMapping("/")
	public String index(Model model,@PageableDefault(size=8, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("items",itemService.writeList(pageable));
		// /WEB-INF/views/index.jsp
		return "index";
	}
	@GetMapping("/item/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("item",itemService.details(id));
		return "item/detail";
	}
	
	@GetMapping("/item/{id}/updateForm")
	public String updateForm(@PathVariable int id, Model model ) {
		model.addAttribute("item",itemService.details(id));
		return "item/updateForm";
	}
	
	
}
