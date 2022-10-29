package com.example.rest.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.persistence.domain.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class AccountDTO {
	@Autowired
    private Long AccountId;

    private Integer NumAccount;
    
    private Integer  AccountBalance; 

    private List<Customer> customer = new ArrayList<>();

	public Long getAccountId() {
		return AccountId;
	}

	public void setAccountId(Long accountId) {
		AccountId = accountId;
	}

	public int getNumAccount() {
		return NumAccount;
	}

	public void setNumAccount(Integer numAccount) {
		NumAccount = numAccount;
	}

	public Integer getAccountBalance() {
		return AccountBalance;
	}

	public void setAccountBalance(Integer accountBalance) {
		AccountBalance = accountBalance;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public AccountDTO(Long accountId, Integer numAccount, Integer accountBalance, List<Customer> customer) {
		super();
		AccountId = accountId;
		NumAccount = numAccount;
		AccountBalance = accountBalance;
		this.customer = customer;
	}

	public AccountDTO() {
		super();
	}

	@Override
	public String toString() {
		return "AccountDTO [AccountId=" + AccountId + ", NumAccount=" + NumAccount + ", AccountBalance="
				+ AccountBalance + ", customer=" + customer + "]";
	}
    

}