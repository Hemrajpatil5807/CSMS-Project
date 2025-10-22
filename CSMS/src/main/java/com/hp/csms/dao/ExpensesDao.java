package com.hp.csms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hp.csms.entity.Expenses;

@Repository
public interface ExpensesDao extends CrudRepository<Expenses, Integer>{
	
	Expenses findBySiteId(int site_id);

}
