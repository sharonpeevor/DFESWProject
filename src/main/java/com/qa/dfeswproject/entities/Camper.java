package com.qa.dfeswproject.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Camper {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String unit;
	
	@Column(nullable = false)
	private LocalDate arrivalDate;
	
	@Column(nullable = false)
	private int noOfNights;

	public Camper() {}

	public Camper(String lastName, String email, String unit, LocalDate arrivalDate, int noOfNights) {
		super();
		this.lastName = lastName;
		this.email = email;
		this.unit = unit;
		this.arrivalDate = arrivalDate;
		this.noOfNights = noOfNights;
	}

	public Camper(long id, String lastName, String email, String unit, LocalDate arrivalDate, int noOfNights) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.unit = unit;
		this.arrivalDate = arrivalDate;
		this.noOfNights = noOfNights;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public int getNoOfNights() {
		return noOfNights;
	}

	public void setNoOfNights(int noOfNights) {
		this.noOfNights = noOfNights;
	}
	
	
}
