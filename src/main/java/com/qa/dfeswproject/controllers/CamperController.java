package com.qa.dfeswproject.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dfeswproject.entities.Camper;

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
}
