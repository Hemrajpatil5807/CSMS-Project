package com.hp.csms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hp.csms.dto.UserReqDto;
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
	public String registerUser(@RequestBody UserReqDto userdto) {

		System.out.println(userdto);

		Users user = new Users(userdto.getName(), userdto.getEmail(), userdto.getPassword(), userdto.getRole());

		boolean is = usersService.register(user);

		if (is)
			return "User Register Succefully";
		else
			return "User Register Succefully";
	}

	@PostMapping("/adduser")
	public String addUser(@RequestBody UserReqDto userdto) {

		Users user = new Users(userdto.getName(), userdto.getEmail(), userdto.getPassword(), userdto.getRole());

		boolean is = usersService.register(user);

		if (is)
			return "User Added Succefully";
		else
			return "User Not Added Succefully";

	}

	@GetMapping("/getallusers")
	public List<Users> getAllUsers() {

		List<Users> users = usersService.getAllUsers();

		return users;
	}

	@PostMapping("/updateuser")
	public String updateUser(@RequestBody UserReqDto userdto) {

		System.out.println(userdto);

		Users user = new Users(userdto.getName(), userdto.getEmail(), userdto.getPassword(), userdto.getRole());
		boolean isUpdated = usersService.updateUser(user);

		if (isUpdated) {
			return "User Update Successfully !";
		} else {
			return "User Not Updated !";
		}
	}

	
	  @DeleteMapping("/deleteuser") 
	  public String deleteUser(@RequestParam String email ) {
		  
		  System.out.println(email);
	 
		 boolean isDelete = usersService.deleteUser(email);
		 
		  if (isDelete) {
				
				return "User Delete Successfully !";
			} else {
				return "User Not Deleted !";
			}

	  }
	  
	  
	  
	  
	  
}
