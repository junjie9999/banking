package com.example.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity

public class Account {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AccountId;
	

    private Integer AccountBalance;
    

    private Integer NumAccount; 
    

    private String AccountName;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Customer> customer = new ArrayList<>();
    @JsonIgnore
	public Long getAccountId() {
		return AccountId;
	}

	public void setAccountId(Long accountId) {
		AccountId = accountId;
	}

	public int getAccountBalance() {
		return AccountBalance;
	}

	public void setAccountBalance(Integer accountBalance) {
		AccountBalance = accountBalance;
	}

	public Integer getNumAccount() {
		return NumAccount;
	}

	public void setNumAccount(Integer numAccount) {
		NumAccount = numAccount;
	}

	public String getAccountName() {
		return AccountName;
	}

	public void setAccountName(String accountName) {
		AccountName = accountName;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public Account(Long accountId, Integer accountBalance, Integer numAccount, String accountName, List<Customer> customer) {
		super();
		AccountId = accountId;
		AccountBalance = accountBalance;
		NumAccount = numAccount;
		AccountName = accountName;
		this.customer = customer;
	}

	public Account() {
		super();
	}

	@Override
	public String toString() {
		return "Account [AccountId=" + AccountId + ", AccountBalance=" + AccountBalance + ", NumAccount=" + NumAccount
				+ ", AccountName=" + AccountName + ", customer=" + customer + "]";
	}//optional 

}