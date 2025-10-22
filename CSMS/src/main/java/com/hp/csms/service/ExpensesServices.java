package com.hp.csms.service;

import java.util.List;

import com.hp.csms.dto.ExpensesDto;
import com.hp.csms.entity.Expenses;

public interface ExpensesServices {

	Expenses addExpense(ExpensesDto expensedto);

	List<Expenses> getAllExpenses();

	Expenses getSiteExpense(int site_id);

	boolean deleteExpense(int expense_id);

	boolean updateExpense(ExpensesDto exp);

}
