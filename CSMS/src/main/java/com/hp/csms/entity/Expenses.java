package com.hp.csms.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;



@Entity
@Table(name="expenses")
@Data
public class Expenses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="expense_id")
	private int expense_id;
	
	@ManyToOne
	@JoinColumn(name="site_id")
	private Sites site_id;
	
	@Column(name="expense_type")
	private String expense_type;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="date")
	private LocalDate date;

	public Expenses() {
	
	}

	public Expenses(int expence_id, Sites site_id, String expense_type, double amount, String date) {
		
		this.expense_id = expence_id;
		this.site_id = site_id;
		this.expense_type = expense_type;
		this.amount = amount;
		this.date = LocalDate.parse(date);
	}
	
	public Expenses( Sites site_id, String expense_type, double amount, String date) {
		
		this.site_id = site_id;
		this.expense_type = expense_type;
		this.amount = amount;
		this.date = LocalDate.parse(date);
	}
	
	
}
