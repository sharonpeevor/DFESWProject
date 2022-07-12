package com.qa.dfeswproject.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/camper")
public class CamperController {

	private CamperService service;

	public CamperController(CamperService service) {
		this.service = service;
	}
	
	
}
