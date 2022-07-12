package com.qa.dfeswproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.dfeswproject.entities.Camper;

@Service
public class CamperService {

	private CamperRepo repo;

	public CamperService(CamperRepo repo) {
		this.repo = repo;
	}
	
	public Camper create(Camper camper) {
		return this.repo.saveAndFlush(camper);
	}
	
	public List<Camper> readAll() {
		return this.repo.findAll();
	}
	
	public Camper readById(long id) {
		return this.repo.findById(id).get();
	}
	
	public Camper update(long id, Camper camper) {
		Camper existing = this.repo.findById(id).get();
		
		existing.setLastName(camper.getLastName());
		existing.setEmail(camper.getEmail());
		existing.setUnit(camper.getUnit());
		existing.setArrivalDate(camper.getArrivalDate());
		existing.setNoOfNights(camper.getNoOfNights());
		
		return this.repo.saveAndFlush(existing);
	}
	
	public boolean delete(long id) {
		this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}
}
