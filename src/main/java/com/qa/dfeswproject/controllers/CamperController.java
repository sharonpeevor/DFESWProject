package com.qa.dfeswproject.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dfeswproject.entities.Camper;
import com.qa.dfeswproject.services.CamperService;

@RestController
@RequestMapping("/camper")
public class CamperController {

	private CamperService service;

	public CamperController(CamperService service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public Camper create(@RequestBody Camper camper) {
		return this.service.create(camper);
	}
	
	@GetMapping("/readAll")
	public List<Camper> readAll(){
		return this.service.readAll();
	}
	
	@GetMapping("/readById/{id}")
	public Camper readById(@PathVariable long id) {
		return this.service.readById(id);
	}
	
	@GetMapping("/readByLastName/{lastName}")
	public List<Camper> readByLastName(@PathVariable String lastName) {
		return this.service.readByLastName(lastName);
	}
	
	@PutMapping("/update/{id}")
	public Camper update(@PathVariable long id, @RequestBody Camper camper) {
		return this.service.update(id, camper);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable long id) {
		return this.service.delete(id);
	}
}
