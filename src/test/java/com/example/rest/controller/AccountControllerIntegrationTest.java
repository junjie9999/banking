package com.example.rest.controller;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.given;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import com.example.persistence.domain.Account;
import com.example.persistence.repository.AccountRepository;
import com.example.rest.dto.AccountDTO;
import com.example.service.AccountService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = "classpath:project.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class AccountControllerIntegrationTest {

		@Autowired
		private AccountService service;
			
		@MockBean
		private AccountRepository repo;

		
		final Account SAVED_ACCOUNT = new Account(1L,2000,234567,"kate" , null);
		
		@Test
		void testCreate() throws Exception
		{
			final Account TEST_ACCOUNT = new Account(null,2000,234567,"kate", null);
			
			given(this.repo.save(TEST_ACCOUNT)).willReturn(TEST_ACCOUNT);
			
			AccountDTO saveDto = this.service.addAccount(TEST_ACCOUNT);
			
			assertThat(saveDto).usingRecursiveComparison().isEqualTo(TEST_ACCOUNT);
		}

//		@Test
//		void testUpdateAccount()
//		{
//			given(repo.save(any(Account.class))).willReturn(SAVED_ACCOUNT);
//			
//			Account SAVED_Account = repo.save(SAVED_ACCOUNT);
//			
//			assertThat(SAVED_Account.updateAccount()).isNotNull();
//		}
		
		@Test
		void testFindAll()
		{
			List<Account> Accounts = new ArrayList<>();
			Accounts.add(SAVED_ACCOUNT);
			Accounts.add(new Account (2L,2000,234567,"james"  , null));
			Accounts.add(new Account (3L, 2000,234567,"john" , null));
			
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