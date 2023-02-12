package com.thecodeveal.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.thecodeveal.app.services.CustomUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration   {

	@Autowired
	private CustomUserService userService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	//este bean es importante para que funcione el authenticationManager
	 @Bean
	    public DaoAuthenticationProvider daoAuthenticationProvider() {
	        DaoAuthenticationProvider provider =
	                new DaoAuthenticationProvider();
	        provider.setPasswordEncoder(passwordEncoder());
	        provider.setUserDetailsService(userService);
	        return provider;
	    }
	
	 @Bean
	    public InMemoryUserDetailsManager userDetailsService() {
	        UserDetails user = User.builder()
	            .username("Ariel")
	            .password(passwordEncoder().encode("root1234"))
	            .roles("USER", "ADMIN")
	            .build();
	        return new InMemoryUserDetailsManager(user);
	    }


	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
	        String[] allowedPathes = new String[]
	        {
	        	"/h2-console/**",
	        	 "/api/v1/auth/login",
	        	 "/api/v1/save/**",

	        };
	        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeHttpRequests().requestMatchers(allowedPathes).permitAll()
			;
	        http.csrf().disable().cors().and().headers().frameOptions().disable();

	        return http.build();

	    };
}
