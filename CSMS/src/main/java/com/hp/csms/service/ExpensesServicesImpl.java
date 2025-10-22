package com.hp.csms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hp.csms.dao.ExpensesDao;
import com.hp.csms.dao.SitesDao;
import com.hp.csms.dto.ExpensesDto;
import com.hp.csms.entity.Expenses;
import com.hp.csms.entity.Sites;

@Service
public class ExpensesServicesImpl implements ExpensesServices {

	@Autowired
	ExpensesDao expensesDao;

	@Autowired
	SitesDao sitesDao;

	Expenses ex = new Expenses();

	@Override
	public Expenses addExpense(ExpensesDto expensedto) {

		Optional<Sites> os = sitesDao.findById(expensedto.getSite_id());

		if (os.isPresent()) {

			ex.setSite_id(os.get());
			ex.setExpense_type(expensedto.getExpense_type());
			ex.setAmount(expensedto.getAmount());
			ex.setDate(expensedto.getDate());

			expensesDao.save(ex);
			return ex;
		}

		return null;
	}

	@Override
	public List<Expenses> getAllExpenses() {

		List<Expenses> exp = (List<Expenses>) expensesDao.findAll();

		if (exp != null)
			return exp;
		else
			return null;
	}

	@Override
	public Expenses getSiteExpense(int site_id) {
		
		Expenses ex = expensesDao.findBySiteId(site_id);
		
		if (ex != null)
			return ex;
		else
			return null;
	}
	
	@Override
	public boolean updateExpense(ExpensesDto exp) {
	
		 return expensesDao.findById(exp.getExpense_id()).map(ex ->{
		        
			 Optional<Sites> os = sitesDao.findById(exp.getSite_id());

			 ex.setSite_id(os.get());
			 ex.setExpense_type(exp.getExpense_type());
			 ex.setDate(exp.getDate());
			 ex.setAmount(exp.getAmount());
		     
			 expensesDao.save(ex);
		     return true;
        	
        }).orElse(false);
		
		
	}

	@Override
	public boolean deleteExpense(int expense_id) {
		expensesDao.deleteById(expense_id);
		
		Optional<Expenses> oex = expensesDao.findById(expense_id);
		if (oex.isEmpty())
			return true;
		else
			return false;
	}


	
	
	

}
