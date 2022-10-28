package com.example.rest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.persistence.domain.Account;
import com.example.persistence.repository.AccountRepository;
import com.example.rest.dto.AccountDTO;
import com.example.service.AccountService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = "classpath:project.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class AccountControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;
	@Autowired
	private AccountService service;
	@Autowired
	private ModelMapper mapper;

	


			
		@MockBean
		private AccountRepository repo;

		
		final Account SAVED_ACCOUNT = new Account(1L,200,3000,"saving" , null);
		
		@Test
		void testCreate() throws Exception
		{
			final Account TEST_ACCOUNT = new Account(null,200,3000,"kate" , null);
			
			given(this.repo.save(TEST_ACCOUNT)).willReturn(TEST_ACCOUNT);
			
			AccountDTO saveDto = this.service.addAccount(TEST_ACCOUNT);
			
			assertThat(saveDto).usingRecursiveComparison().isEqualTo(TEST_ACCOUNT);
		}

	
		
		@Test
		void testFindAll()
		{
			List<Account> Accounts = new ArrayList<>();
			Accounts.add(SAVED_ACCOUNT);
			Accounts.add(new Account (2L,200,3000,"saving" , null));
			Accounts.add(new Account (3L,200,3000,"saving" , null));
			
			given(repo.findAll()).willReturn(Accounts);
			
			List<AccountDTO> expected = service.getAllAccount();
			
			assertThat(expected).usingRecursiveComparison().isEqualTo(Accounts);
		}
		
		@Test
		void testFindById()
		{
			final Long id = 1L;
			final Account TEST_Account_ID = new Account();
			
			given(repo.findById(id)).willReturn(Optional.of(TEST_Account_ID));
			
			final AccountDTO expected = service.readById(id);
			
			assertThat(expected).isNotNull();
		}
		
		@Test
		void testDeletion()
		{
			final Long id = 1L;
			
			service.deleteAccount(id);
			service.deleteAccount(id);
			
			verify(repo, times(2)).deleteById(id);
		}
}
//final Account SAVED_ACCOUNT = new Account(1L,200,3000,"saving" , null);