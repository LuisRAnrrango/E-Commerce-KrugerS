package com.thecodeveal.app;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.thecodeveal.app.entities.Authority;
import com.thecodeveal.app.entities.User;
import com.thecodeveal.app.repository.UserDetailsRepository;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableEurekaClient
public class SpringSecurityDemoAppApplication {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoAppApplication.class, args);
	}
	
	@PostConstruct
	protected void init() {
		
		List<Authority> authorityList=new ArrayList<>();
		
		authorityList.add(createAuthority("USER","User role"));
		authorityList.add(createAuthority("ADMIN","Admin role"));
		//System.out.println(authorityList);
		User user=new User();
		
		user.setUserName("luisito1234");
		user.setFirstName("Luis");
		user.setLastName("Anrrango");
		
		user.setPassword(passwordEncoder.encode("luisito-123"));
		user.setEnabled(true);
		user.setAuthorities(authorityList);
		//System.out.println(user);
	//	userDetailsRepository.save(user);
		
		
		
	}
	
	
	private Authority createAuthority(String roleCode,String roleDescription) {
		Authority authority=new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}
	
	

}
