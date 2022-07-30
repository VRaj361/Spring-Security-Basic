package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/public")
public class SessionController {
	
	@GetMapping("/signup")
	public String getSignup() {
		System.out.println("in Signin");
		return "Signup";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		System.out.println("in Login");
		return "/Login";
	}
	
	@PostMapping("/verify")
	public String authenticate() {
		System.out.println("in verify authenticated");
		//databases logic ---> username and password
		return "Home";
	}
}
