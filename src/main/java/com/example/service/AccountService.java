package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.AccountNotFoundException;
import com.example.exception.CustomerNotFoundException;
import com.example.persistence.domain.Account;
import com.example.persistence.repository.AccountRepository;
import com.example.rest.dto.AccountDTO;


@Service

public class AccountService {
	@Autowired
	private AccountRepository repo;
	@Autowired
	private ModelMapper mapper;
	
	private AccountDTO mapToDTO(Account account) {
		return this.mapper.map(account, AccountDTO.class);
	}
	
	public AccountDTO addAccount(Account account) {
		Account saved = this.repo.save(account);
		return this.mapToDTO(saved);
	}
	
	public List<AccountDTO> getAllAccount() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public AccountDTO updateAccount(long accountId, Account account) {
		Optional<Account> A = Optional.of(this.repo.findById(accountId).orElseThrow(CustomerNotFoundException::new));
		Account existing = A.get();
		
		existing.setAccountBalance(account.getAccountBalance());
		existing.setAccountName(account.getAccountName());
		existing.setCustomer(account.getCustomer());
		
		Account updated = this.repo.save(existing);
		return this.mapToDTO(updated);
	}
	
	public boolean deleteAccount(long Accountid) {
		this.repo.findById(Accountid).orElseThrow(AccountNotFoundException::new);
		this.repo.deleteById(Accountid);
		boolean exists = this.repo.existsById(Accountid);
		return !exists;
	}
	
	public AccountDTO readById(long Accountid) {
		Account found = this.repo.findById(Accountid).orElseThrow(AccountNotFoundException::new);
        return this.mapToDTO(found);
    }
	
//	public AccountDTO readByName(String AccountName) {
//		Account found = this.repo.accountByName(AccountName).orElseThrow(AccountNotFoundException::new);
//		return this.mapToDTO(found);
//	
//	}
//	
}
