package com.cognixia.jump.model;

// model object used to send in username & password when user first authenticates and needs to create JWT on
//the /authenticate POST request 
public class AuthRequest {
	
	private String username;
	private String password;
	
	public AuthRequest() {
		//default constructor
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
