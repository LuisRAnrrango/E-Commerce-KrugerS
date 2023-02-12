package com.thecodeveal.app.services;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.netflix.discovery.converters.Auto;
import com.thecodeveal.app.config.JWTTokenHelper;
import com.thecodeveal.app.entities.User;
import com.thecodeveal.app.repository.UserDetailsRepository;
import com.thecodeveal.app.requests.AuthenticationRequest;
import com.thecodeveal.app.responses.LoginResponse;


@Service
public class CustomUserService implements UserDetailsService {
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Autowired
	JWTTokenHelper jwtToken;
	
	@Autowired
	@Lazy
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user=userDetailsRepository.findByUserName(username);
		
		if(null==user) {
			throw new UsernameNotFoundException("User Not Found with userName "+username);
		}
		return user;
	}
	
	public User save(User user) {
		return userDetailsRepository.save(user);
	}
	
		public LoginResponse login(AuthenticationRequest dto) {
		UserDetails user = this.loadUserByUsername(dto.getUserName());
		if (user==null)
			return null;
		if (passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
			LoginResponse response = new LoginResponse();
			try {
				response.setToken(jwtToken.generateToken(user.getUsername()));
			} catch (InvalidKeySpecException e) {
				return null;
			} catch (NoSuchAlgorithmException e) {
				return null;
			}
			return response;
		}
		return null;
	}

}
