package com.hp.csms.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ExpensesDto {

	private int expense_id;

	private int site_id;

	private String expense_type;

	private double amount;

	private LocalDate date;

	public ExpensesDto() {}

	public ExpensesDto(int expense_id, int site_id, String expense_type, double amount, String date) {

		this.expense_id = expense_id;
		this.site_id = site_id;
		this.expense_type = expense_type;
		this.amount = amount;
		this.date = LocalDate.parse(date);
	}

	public ExpensesDto(int site_id, String expense_type, double amount, String date) {

		this.site_id = site_id;
		this.expense_type = expense_type;
		this.amount = amount;
		this.date = LocalDate.parse(date);
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = LocalDate.parse(date);
		;
	}

}
