package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	
	@GetMapping("/user/home")
	public String getHome() {
		System.out.println("in Home");
		return "Home";
	}
	
	@GetMapping("/admin/dashboard")
	public String getDashboard() {
		System.out.println("in Dashboard");
		return "Dashboard";
	}
	
	@GetMapping("/public/signin")
	public String getSignup() {
		System.out.println("in Login");
		return "Login";
	}
}
