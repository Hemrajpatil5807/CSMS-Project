package com.hp.csms.dao;

import org.springframework.data.repository.CrudRepository;

import com.hp.csms.entity.Sites;
import com.hp.csms.entity.Users;

public interface SitesDao extends CrudRepository<Sites, Integer>{

	Users findByName(String manager_name);

}
