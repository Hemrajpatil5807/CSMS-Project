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
@Table(name="sites")
@Data
public class Sites {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="site_id")
	private int site_id;
	
	@Column(name="site_name")
	private String site_name;
	
	@Column(name="location")
	private String location;
	
	@Column(name="start_date")
    private LocalDate startDate;
	  
	@Column(name="end_date")
    private LocalDate endDate; 
	
	@Column(name="status")
    private String status;
	
    @ManyToOne
    @JoinColumn(name="user_id")
	private Users manager_id;
    

	public Sites() {

	}

	public Sites(int site_id, String site_name, String location, String startDate, String endDate, String status, Users manager_id) {
		
		this.site_id = site_id;
		this.site_name = site_name;
		this.location = location;
		this.startDate = LocalDate.parse(startDate);
		this.endDate = LocalDate.parse(endDate);
		this.status = status;
		this.manager_id = manager_id;
	}
	
    public Sites( String site_name, String location, String startDate, String endDate, String status, Users manager_id) {
		
		this.site_name = site_name;
		this.location = location;
		this.startDate = LocalDate.parse(startDate);
		this.endDate = LocalDate.parse(endDate);
		this.status = status;
		this.manager_id = manager_id;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = LocalDate.parse(startDate);
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = LocalDate.parse(endDate);
	}

    
}
