package com.qa.dfeswproject.services;

import org.springframework.stereotype.Service;

@Service
public class CamperService {

	private CamperRepo repo;

	public CamperService(CamperRepo repo) {
		this.repo = repo;
	}
	
	
}
