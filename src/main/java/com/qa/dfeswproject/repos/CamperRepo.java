package com.qa.dfeswproject.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.dfeswproject.entities.Camper;

@Repository
public interface CamperRepo extends JpaRepository<Camper, Long> {

	List<Camper> findCamperByLastName(String lastName);
	
}
