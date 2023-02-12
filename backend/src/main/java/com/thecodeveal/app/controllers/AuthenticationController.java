package com.thecodeveal.app.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thecodeveal.app.config.JWTTokenHelper;
import com.thecodeveal.app.entities.User;
import com.thecodeveal.app.requests.AuthenticationRequest;
import com.thecodeveal.app.responses.LoginResponse;
import com.thecodeveal.app.responses.UserInfo;
import com.thecodeveal.app.services.CustomUserService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	JWTTokenHelper jWTTokenHelper;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private CustomUserService customUserService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest)
			throws InvalidKeySpecException, NoSuchAlgorithmException {
		/*
		 * MANERA #1
		 * para autenticar un usuario puedes utilizar este metodo que crei en el
		 * customUserService class lo que hace login es buscar si el usuario existe en
		 * el base de datos y luego se verfica si el password esta correcto, caso
		 * posititvo te develve el loginResponse caso negativo te devuelve null
		 */

		/*
		 * LoginResponse response=customUserService.login(authenticationRequest); return
		 * response!=null ? ResponseEntity.ok(response) :
		 * ResponseEntity.badRequest().build();
		 */
//---------------------------------------------------------------
		//MANERA #2
		// el codigo antiguo que hace la autenticacion por medio de authenticationManager
		//ambas maneras funcionan
		// es recomendado que pasas todo esta logica al service
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUserName(), authenticationRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		User user = (User) authentication.getPrincipal();
		String jwtToken = jWTTokenHelper.generateToken(user.getUsername());
		LoginResponse response = new LoginResponse();
		response.setToken(jwtToken);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/auth/userinfo")
	public ResponseEntity<?> getUserInfo(Principal user) {
		User userObj = (User) userDetailsService.loadUserByUsername(user.getName());

		UserInfo userInfo = new UserInfo();
		userInfo.setFirstName(userObj.getFirstName());
		userInfo.setLastName(userObj.getLastName());
		userInfo.setRoles(userObj.getAuthorities().toArray());

		return ResponseEntity.ok(userInfo);

	}

	@PostMapping("/save/user")
	public ResponseEntity<?> save(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User newuser = customUserService.save(user);
		return ResponseEntity.ok(newuser);
	}
}