package com.hp.csms.dto;

import lombok.Data;

@Data
public class SitesDto {

	
	private int site_id;
	
	private String site_name;
	
	private String location;
	
    private String startDate;
	  
    private String endDate;
    
    private String status;

	private String manager_name;

	public SitesDto() {
		
	}

	public SitesDto(int site_id, String site_name, String location, String startDate, String endDate, String status, String manager_name) {
	
		this.site_id = site_id;
		this.site_name = site_name;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.manager_name = manager_name;
	}
	
	public SitesDto(String site_name, String location, String startDate, String endDate, String status, String manager_name) {
		
		this.site_name = site_name;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.manager_name = manager_name;
	}

	

	
}
