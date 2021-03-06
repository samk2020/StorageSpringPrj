package com.cognixia.jump.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.User;

@Repository
public interface UserDataSet extends JpaRepository<User, Long> {
	public Optional<User> findByUserName(String usr);
	
}