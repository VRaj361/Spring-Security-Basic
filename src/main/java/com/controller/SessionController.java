package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CustomerDetail;
import com.entity.UserBean;
import com.repository.JPARepository;

@Controller
@RequestMapping("/public")
public class SessionController {
	
	@Autowired
	JPARepository userRepo;
	
	@Autowired
	BCryptPasswordEncoder bcrypt;
	
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
	
	@PostMapping("/saveuser")
	public String saveUser(UserBean user) {
		System.out.println("save user");
		user.setRole("ROLE_USER");
		String x = bcrypt.encode(user.getPassword());
		user.setPassword(x);
		userRepo.save(user);
		return "Login";
	}
}
