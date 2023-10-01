package com.openclassrooms.api;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;



@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

	@Autowired
	public MockMvc mockMvc;
	
	@Test
	public void testGetEmployees() throws Exception {
		
		mockMvc.perform(get("/employees")).andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName", is("Laurent")));		
	}

	
	@Test
	public void testGetEmployees2() throws Exception {
		
		
		String requestBody = "{\"firstName\":\"John\", \"lastName\":\"Doe\", \"mail\":\"Doe@gmail.com\", \"password\":\"ras\" }";

	    mockMvc.perform(post("/employee")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(requestBody))
	            .andExpect(status().isCreated());
		
	}
	
	
	@Test
	public void testGetEmployees3() throws Exception {
		
		
		String requestBody = "{\"firstName\":\"John\", \"lastName\":\"Doe\", \"mail\":\"Doe@gmail.com\", \"password\":\"ras\" }";

	    mockMvc.perform(put("/employee/2")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(requestBody))
	            .andExpect(status().isOk());
		
	}
	
	@Test
	public void testDeleteEmployee() throws Exception {
	    mockMvc.perform(delete("/employee/2"))
	            .andExpect(status().isOk());
	}

	
}

