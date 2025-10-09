package com.hp.csms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hp.csms.entity.Users;
import com.hp.csms.service.UsersService;

@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	UsersService usersService;
	
	@GetMapping("/welcome")
	public String user() {
		return "Welcome User";
	}
	
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute Users user) {
		
		boolean is = usersService.register(user);
		
		if(is)
		  return "User Register Succefully";
		else
			return "User Register Succefully";
	}
	
	
}
