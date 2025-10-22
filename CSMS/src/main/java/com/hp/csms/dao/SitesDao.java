package com.hp.csms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hp.csms.entity.Sites;
import com.hp.csms.entity.Users;

@Repository
public interface SitesDao extends CrudRepository<Sites, Integer>{

	Users findByName(String manager_name);

}
