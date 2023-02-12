package com.thecodeveal.app.entities;


import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "AUTH_AUTHORITY")
@Entity
public class Authority implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "ROLE_CODE")
	private String roleCode;
	
	@Column(name = "ROLE_DESCRIPTION")
	private String roleDescription;
	
	

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return roleCode;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getRoleCode() {
		return roleCode;
	}



	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}



	public String getRoleDescription() {
		return roleDescription;
	}



	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	
	
}