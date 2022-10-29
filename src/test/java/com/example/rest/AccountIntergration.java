package com.example.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.persistence.domain.Account;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = "classpath:project.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class AccountIntergration {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	private final Account TEST_ACCOUNT = new Account(null,2000,234567,"kate" , null);

	private final Account TEST_SAVED_ACCOUNT = new Account(1L,2000,234567,"james" , null);

	@Test
	public void testCreate() throws JsonProcessingException, Exception {
		String resultString = this.mockMVC
				.perform(post("/account/addAccount").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(TEST_ACCOUNT)))
				.andExpect(status().isCreated()).andReturn().getRequest().getContentAsString();

		Account result = this.mapper.readValue(resultString, Account.class);
		assertThat(result).isEqualTo(TEST_ACCOUNT);
	}

	@Test
	public void testReadAll() throws Exception {
		this.mockMVC.perform(get("/account/readall/1")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(TEST_SAVED_ACCOUNT)));

	}

	@Test
	public void testZZZ() throws Exception {
		final List<Account> ACCOUNT = new ArrayList<>();
		ACCOUNT.add(TEST_SAVED_ACCOUNT);

		final String resultString = this.mockMVC
				.perform(request(HttpMethod.GET, "/account/allAccount").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		List<Account> results = Arrays.asList(mapper.readValue(resultString, Account[].class));
		assertThat(results).contains(this.TEST_ACCOUNT).hasSize(3);
	}

	@Test
	public void testUpdate() throws Exception {
		final Account newAccount = new Account(null,2000,234567,"john" , null);
		String resultString = this.mockMVC
				.perform(put("/account/updateAccount/1").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(newAccount)))
				.andExpect(status().isAccepted()).andReturn().getRequest().getContentAsString();

		Account result = this.mapper.readValue(resultString, Account.class);
		assertThat(result).isEqualTo(newAccount);
	}

	@Test
	public void testDelete() throws Exception {
		this.mockMVC.perform(delete("/account/deleteAccount/1")).andExpect(status().isNoContent());
	}
}

	


