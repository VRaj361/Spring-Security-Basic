package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/public")
public class SessionController {
	
	@GetMapping("/signup")
	public String getSignup() {
		return "Signup";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "/Login";
	}
}
