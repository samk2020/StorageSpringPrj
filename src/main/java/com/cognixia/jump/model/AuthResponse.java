package com.cognixia.jump.model;

//response object for when /authenticate POST request is called and returns the jwt created
//response object for when /authenticate POST request is called and returns the jwt created
public class AuthResponse {
	
	private String jwt;
	
	public AuthResponse(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

}


//old code for reference
/*
import java.util.Objects;

import java.io.Serializable;

public class AuthResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String ticketId;

	public AuthResponse(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getToken() {
		return this.ticketId;
	}
} 
*/