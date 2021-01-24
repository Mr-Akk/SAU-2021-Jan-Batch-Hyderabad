package com.RestAPIAfternoon.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	
	@GetMapping("/")
	private String showWelcome() {
		
		return "Welcome";

	}
	

}
