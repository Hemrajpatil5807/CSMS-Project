package com.hp.csms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="materials")
@Data
public class Materials {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="material_id")
	private int material_id;
	
	@Column(name="material_name")
	private String material_name;
	
	@Column(name="unit")
	private String unit;
	
	@Column(name="available_stock")
	private int available_stock;
	
	@Column(name="unitPrice")
	private double unitPrice;
	
	

	public Materials() {
	
	}

	public Materials(int material_id, String material_name, String unit, int available_stock, double unitPrice) {
		
		this.material_id = material_id;
		this.material_name = material_name;
		this.unit = unit;
		this.available_stock = available_stock;
		this.unitPrice = unitPrice;
	}

	public Materials(String material_name, String unit, int available_stock, double unitPrice) {

		this.material_name = material_name;
		this.unit = unit;
		this.available_stock = available_stock;
		this.unitPrice = unitPrice;
	}
	
	
	
}
