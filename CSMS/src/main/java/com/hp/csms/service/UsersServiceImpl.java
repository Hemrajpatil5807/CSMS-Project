package com.hp.csms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.csms.dao.UsersDao;
import com.hp.csms.entity.Users;

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
	
	

}
