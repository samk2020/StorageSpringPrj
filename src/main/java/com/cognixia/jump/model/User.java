package com.cognixia.jump.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

// username as usr, password as psw, email
@Entity
public class User { 
	
	public static enum Role {
		ROLE_USER, ROLE_ADMIN  
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@Column(nullable = false)
	private String usr;

	@NotBlank
	@Column(nullable = false)
	private String psw;  
	
	@NotBlank
	@Column(nullable = false)
	private String email;
	
	@OneToMany(mappedBy= "id", cascade = CascadeType.ALL)
	private List<Orders> orders;
	
	public User() {
		this.orders = new ArrayList<Orders>();
	} 
	
	public User(Integer id, String username, String email, @NotBlank String password, List<Orders> orders) {
		super();
		this.id = id;
		this.usr = usr;
		this.psw = psw; 
		this.email = email;
		this.orders = orders;
	} 
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return usr;
	}

	public void setUserName(String usr) {
		this.usr = usr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return psw;
	}

	public void setPassword(String psw) {
		this.psw = psw;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", usr=" + usr + ", psw=" + psw + ", email=" + email + ", orders=" + orders + "]";
	}

	public Object getRole() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	} 
	
	
	

}
