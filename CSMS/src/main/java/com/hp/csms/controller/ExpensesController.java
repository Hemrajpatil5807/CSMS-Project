package com.hp.csms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hp.csms.dto.ExpensesDto;
import com.hp.csms.entity.Expenses;
import com.hp.csms.service.ExpensesServices;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {
	
	@Autowired
	ExpensesServices expensesServices;
	
	
	@PostMapping("/addexpense")
	public String registerExpense(@RequestBody ExpensesDto expensedto) {
		
		Expenses ex = expensesServices.addExpense(expensedto);
		
		if(ex!=null)
			return "Expense Added Succefully !";
		else
			return "Expense Not Added Succefully !";
		
	}
	
//	@PostMapping("/addSiteExpense")
//	public String addExpense(@RequestBody Expenses expense) {
//		
//		expensesServices.addExpense(expense);
//		
//		return "forward:/managerdash"; 
//		
//	}
	
	@GetMapping("/getsiteexpense")
	public Expenses getSiteExpense(@RequestParam int site_id) {
		
		Expenses expense = expensesServices.getSiteExpense(site_id);
		
		if(expense!=null)
		     return expense;
		else
			return null;
	}
	
	
	@GetMapping("/getallexpenses")
	public List<Expenses> getAllExpenses() {
		
		List<Expenses> expenses = expensesServices.getAllExpenses();
		
		if(expenses!=null)
		     return expenses;
		else
			return null;
	}
	
	@PutMapping("/updateexpense")
	public String updateExpense(@RequestBody ExpensesDto exp) {
		
		boolean isUpdate = expensesServices.updateExpense(exp);
		
		return null;
	}
	
	@DeleteMapping("/deleteexpense")
	public String deleteExpense(@RequestParam int expense_id){
		
		boolean isDelete = expensesServices.deleteExpense(expense_id);
		
		if(isDelete)
			return "Expense Deleted Successfully";
		else 
		    return "Expense Not Deleted Successfully";
	}
	
	
	
	

}
