package com.example.rest.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.persistence.domain.Account;
import com.example.rest.dto.AccountDTO;
import com.example.service.AccountService;


@RestController

public class AccountController {
	@Autowired
	private AccountService service;
	
	@PostMapping("/addAccount")
	public AccountDTO addaccount(@RequestBody Account account) {
		return service.addAccount(account);
	}
	
	@GetMapping("/allAccount")
	public List<AccountDTO> getAllAccount(){
		return service.getAllAccount();
	}
	
	@PutMapping("/updateAccount/{AccountId}")
	public AccountDTO updateAccount(@PathVariable long AccountId, @RequestBody Account account){
		return service.updateAccount(AccountId, account);

	}
	
	@DeleteMapping("/deleteAccount/{AccountId}")
	public boolean deleteAccount(@PathVariable long AccountId) {
		return service.deleteAccount(AccountId);
	}
	
	@GetMapping("/readById")
	public AccountDTO readAccountById(@PathParam("id") long AccountId) {
		return service.readById(AccountId);
	}
	
//	@GetMapping("/AccountByName")
//	public AccountDTO readByName(@PathParam("name") String AccountName){
//		return service.readByName(AccountName);
//	}

}
