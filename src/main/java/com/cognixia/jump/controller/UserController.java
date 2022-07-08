package com.cognixia.jump.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.AuthRequest;
import com.cognixia.jump.model.AuthResponse;
import com.cognixia.jump.util.JwtUtil;

@RestController 
@RequestMapping("/api/user")
public class UserController {
	
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	

	@GetMapping("/hello")
	public String getHello() {
		return "Hello User";
	}
	

	
	@PostMapping("/authenticate") 
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest request) throws Exception {
		
		
		try {
			authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()) );
			
		} catch(BadCredentialsException e) {
			throw new Exception("Please try again with login info!");
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername( request.getUsername() );
		final String jwt = jwtUtil.generateTokens(userDetails);
		return ResponseEntity.status(201).body( new AuthResponse(jwt) );
	}
	
	
}