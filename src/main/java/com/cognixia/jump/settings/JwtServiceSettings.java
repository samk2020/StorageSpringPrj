package com.cognixia.jump.settings;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognixia.jump.repository.UserDataSet;

@Service
public class JwtServiceSettings implements UserDetailsService {

	UserDataSet set;

    JwtServiceSettings(UserDataSet set) {
        this.set = set;
    }
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<com.cognixia.jump.model.User> userFound = set.findByEmail(email);
		if (userFound.isEmpty()) {
			throw new UsernameNotFoundException(email);
		}
		
		return new JwtServiceSettings(userFound.get());
	}
}