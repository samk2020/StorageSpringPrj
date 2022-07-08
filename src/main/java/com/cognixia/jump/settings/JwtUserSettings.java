package com.cognixia.jump.settings;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.cognixia.jump.model.Orders;
import com.cognixia.jump.repository.UserDataSet;

public class JwtUserSettings  implements UserDataSet {

	private static final long serialVersionUID = 1L;
	private String user; //user
	private String password; //password
	private String email; //email
	private boolean enabled;
	private List<GrantedAuthority> data;
	
	public JwtUserSettings(User user) {
		this.user = user.getUsername();
		this.password = user.getPassword(); 
		
		this.enabled = user.isEnabled();
		
		this.data = Arrays.asList(new SimpleGrantedAuthority(user.getRole().name()));
	}
	
	public Collection <? extends GrantedAuthority>  getAuthorities() {
		
		return data;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return user;
	} 
	
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	} 
	
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	} 
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

}
