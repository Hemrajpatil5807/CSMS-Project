package com.hp.csms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hp.csms.entity.Users;

@Repository
public interface UsersDao extends CrudRepository<Users, Integer>{

	Users findByEmail(String email);

    void deleteByEmail(String email);

}
