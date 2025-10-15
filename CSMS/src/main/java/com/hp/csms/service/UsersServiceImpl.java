package com.hp.csms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.csms.dao.UsersDao;
import com.hp.csms.entity.Users;

import jakarta.transaction.Transactional;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	UsersDao usersDao;

	@Override
	public boolean register(Users user) {
		
		Users u = usersDao.save(user);
		
		if (u != null)
			return true;
		else
			return false;
	}

	@Override
	public List<Users> getAllUsers() {
		
		List<Users> users = (List<Users>) usersDao.findAll();
		
		if (users != null)
			return users;
		else
			return null;
	}

	@Override
	public boolean updateUser(Users user) {
		
	  Users u = usersDao.findByEmail(user.getEmail());
	  
	  if(u != null) {
		  
		  u.setName(user.getName());
		  u.setEmail(user.getEmail());
		  u.setPassword(user.getPassword());
		  u.setRole(user.getRole());
		  
		 if( usersDao.save(u) != null);
		    return true;
	  }
	  
	  return false;
	}

	@Override
	@Transactional
	public boolean deleteUser(String email) {
		
		usersDao.deleteByEmail(email);
		Users ou = usersDao.findByEmail(email);
		if (ou != null)
			return false;
		else
			return true;
		
	}
	
	

}
