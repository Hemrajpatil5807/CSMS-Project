package com.hp.csms.service;

import java.util.List;

import com.hp.csms.entity.Users;

public interface UsersService {

	public boolean register(Users user);

	public List<Users> getAllUsers();

	public boolean updateUser(Users user);

	public boolean deleteUser(String email);
	
}
