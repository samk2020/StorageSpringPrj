package com.cognixia.jump.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Plans;
// this is used for selecting a capacity for cloud storage due to
//	virtual item that's not restricted with inventory
@Repository
public interface CapacityRepo extends JpaRepository<Plans, Long>{

}
