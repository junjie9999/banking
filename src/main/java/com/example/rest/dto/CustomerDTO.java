package com.example.rest.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.persistence.domain.Account;




public class CustomerDTO {
	@Autowired
	private Long Cusomterid;

	private String CustomerName;
	
    private String Email ;

    private String username;
    
    private String Password ;

    private Account account;
    
    private Long PhoneNumber;
    
    private String AccountType;

	public Long getCusomterid() {
		return Cusomterid;
	}

	public void setCusomterid(Long cusomterid) {
		Cusomterid = cusomterid;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public long getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getAccountType() {
		return AccountType;
	}

	public void setAccountType(String accountType) {
		AccountType = accountType;
	}

	public CustomerDTO(Long cusomterid, String customerName, String email, String username, String password,
			Account account, Long phoneNumber, String accountType) {
		super();
		Cusomterid = cusomterid;
		CustomerName = customerName;
		Email = email;
		this.username = username;
		Password = password;
		this.account = account;
		PhoneNumber = phoneNumber;
		AccountType = accountType;
	}

	public CustomerDTO() {
		super();
	}

	@Override
	public String toString() {
		return "CustomerDTO [Cusomterid=" + Cusomterid + ", CustomerName=" + CustomerName + ", Email=" + Email
				+ ", username=" + username + ", Password=" + Password + ", account=" + account + ", PhoneNumber="
				+ PhoneNumber + ", AccountType=" + AccountType + "]";
	}
    

   


}
