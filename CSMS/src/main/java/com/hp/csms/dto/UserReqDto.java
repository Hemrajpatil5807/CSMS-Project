package com.hp.csms.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
public class UserReqDto {
	
    private String name;
	
	private String email;
	
	private String password;
	
	private String role;

	public UserReqDto() {}

	public UserReqDto(String name, String email, String password, String role) {

		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	

}
