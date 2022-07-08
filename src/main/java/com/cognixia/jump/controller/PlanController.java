package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Plans;
import com.cognixia.jump.repository.CapacityRepo;



@RequestMapping("/api")
@RestController
public class PlanController {
	
	@Autowired
	CapacityRepo repo;
	
	@GetMapping("/plans")
	public List<Plans> getPlans() {
		return repo.findAll();
	}
	
	@PostMapping("/plans")
	public ResponseEntity<Plans> createProduct(@RequestBody Plans plan) {
		
		plan.setId(-1);
		
		Plans created = repo.save(plan);
		
		return ResponseEntity.status(201).body(created);
	}
}
