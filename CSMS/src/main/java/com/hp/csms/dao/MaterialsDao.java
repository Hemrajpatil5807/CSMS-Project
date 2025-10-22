package com.hp.csms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hp.csms.entity.Materials;

@Repository
public interface MaterialsDao extends CrudRepository<Materials, Integer>{
	
	

}
