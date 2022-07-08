package com.cognixia.jump.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.User;
//import com.cognixia.jump.service.MyUserDetails;
import com.cognixia.jump.util.JwtUtil;
public class AuthenticateController {
	@RestController
	@RequestMapping("/api/auth")

	public class AuthController {

		@Autowired
		private UserDetailsService userDetailsService;

		@Autowired
		private JwtUtil jwtUtil;

		@Autowired
		private AuthenticationManager authenticationManager;

		@PostMapping("/login")
		public ResponseEntity<?> login(@RequestBody AuthenticateController request) {
			UserDetails userDataSet = userDetailsService.loadUserByUsername(request.getUsername());
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			String jwt = jwtUtil.generateToken(userDetails);
			return ResponseEntity.ok(jwt);

		}
	}

}
