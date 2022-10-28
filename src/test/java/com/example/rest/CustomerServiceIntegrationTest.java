package com.example.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.persistence.domain.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerServiceIntegrationTest
{
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private final Customer TEST_Customer = new Customer(1L, "some guy","randomguy@gmail.com","guy","guy0987654345434",(long) 453,"saving account",null);
	
	@Test
	public void testCreateUser() throws Exception
	{
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/customer/addCustomer");
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(this.objectMapper.writeValueAsString(TEST_Customer));
		mockRequest.accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
		//ResultMatcher matchContent = MockMvcResultMatchers.content().json(this.objectMapper.writeValueAsString(CreateUserDto.class));
		
		this.mock
			.perform(mockRequest)
			.andExpect(matchStatus);
			//.andExpect(matchContent);
		
		
		
		
		
		
	}
}

