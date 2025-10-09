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
@Table(name="site_materials")
@Data
public class SiteMaterials {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="site_id")
	private Sites site_id;
	
	@ManyToOne
	@JoinColumn(name="material_id")
	private Materials material_id;
	
	@Column(name="used_quantity")
	private int used_quantity;
	
	@Column(name="date_used")
	private LocalDate date_used;

	public SiteMaterials() {
	
	}

	public SiteMaterials(int id, Sites site_id, Materials material_id, int used_quantity, String date_used) {
		
		this.id = id;
		this.site_id = site_id;
		this.material_id = material_id;
		this.used_quantity = used_quantity;
		this.date_used = LocalDate.parse(date_used);
	}

   public SiteMaterials(Sites site_id, Materials material_id, int used_quantity, String date_used) {
		
		this.site_id = site_id;
		this.material_id = material_id;
		this.used_quantity = used_quantity;
		this.date_used = LocalDate.parse(date_used);
	}
	
	

}
