package com.qa.dfeswproject.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.dfeswproject.entities.Camper;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class CamperControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void createTest() throws Exception {
		Camper entry = new Camper("Smith", "johnsmith@gmail.com", "caravan", "01/08/22", 7);
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Camper result = new Camper(2L, "Smith", "johnsmith@gmail.com", "caravan", "01/08/22", 7);
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(post("/camper/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void readAllTest() throws Exception {
		List<Camper> output = new ArrayList<>();
		Camper entry = new Camper(1L, "Peevor", "shazpeevor@hotmail.com", "campervan", "16/07/22", 3);
		output.add(entry);
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(get("/camper/readAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(outputAsJSON));
	}
	
	@Test
	public void readByIdTest() throws Exception {
		Camper entry = new Camper(1L, "Peevor", "shazpeevor@hotmail.com", "campervan", "16/07/22", 3);
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		mvc.perform(get("/camper/readById/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(entryAsJSON));
	}
	
	@Test
	public void readByLastName() throws Exception {
		List<Camper> output = new ArrayList<>();
		Camper entry = new Camper(1L, "Peevor", "shazpeevor@hotmail.com", "campervan", "16/07/22", 3);
		output.add(entry);
		String outputAsJSON = mapper.writeValueAsString(output);
		
		mvc.perform(get("/camper/readByLastName/Peevor")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(outputAsJSON));
	}
	
	@Test
	public void updateTest() throws Exception {
		Camper entry = new Camper("Smith", "johnsmith@gmail.com", "caravan", "01/08/22", 7);
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		Camper result = new Camper(1L, "Smith", "johnsmith@gmail.com", "caravan", "01/08/22", 7);
		String resultAsJSON = this.mapper.writeValueAsString(result);
		
		mvc.perform(put("/camper/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	@Test
	public void deleteTest() throws Exception {
		mvc.perform(delete("/camper/delete/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().string("true"));
	}
}
