package com.cg.Admin.models;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data

public class Role implements GrantedAuthority{
	
	@Id
	private String rusername;
	private String name;
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}

}
