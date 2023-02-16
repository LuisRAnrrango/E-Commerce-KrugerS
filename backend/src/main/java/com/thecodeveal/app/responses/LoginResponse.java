package com.thecodeveal.app.responses;

import java.util.List;

import com.thecodeveal.app.entities.Authority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
	
	private Long id;
	
	private String token;
	
	private String userName , firstName, lastName, email,phoneNumber,password;
	private Object roles;
	

	

}
