package com.dbInterview.TradeDemo.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
class TradeStoreControllerTest {
	
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	
	@BeforeAll
	private void setUp() {
		System.out.println("set up called");
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testHealthCheck() throws Exception {
		
	//	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	MvcResult result =	mockMvc.perform(get("/health"))
						.andExpect(status()
						.isOk())
						.andReturn();
	
	assertTrue(result.getResponse().getContentAsString().equals("Welcome to Trade Store App"));
		
	}

	@Test
	void testGetAllTrades() {
		
	}

	@Test
	void testAddTrade() {
	}

}
