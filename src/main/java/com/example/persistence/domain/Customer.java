package com.example.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity

public class Customer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Cusomterid;

    @NotNull
    @Size(min = 0, max = 55)
    private String CustomerName;
    @NotNull
    //@Min(0)
    //@Max(100)
    private String Email ;

    @NotNull
    private String username;
    
    @NotNull
   // @Min(0)
    //@Max(8)
    private String Password ;
    
    
    @Size( max = 11)
    private Long PhoneNumber;
    

    
    private String AccountType;

    @ManyToOne
    private Account account;

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

	public Long getPhoneNumber() {
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Customer(Long cusomterid, @NotNull @Size(min = 0, max = 55) String customerName,
			@NotNull @Min(0) @Max(100) String email, @NotNull String username, @NotNull @Min(0) @Max(8) String password,
			@Size(min = 0, max = 55) Long phoneNumber, @NotNull String accountType, Account account) {
		super();
		Cusomterid = cusomterid;
		CustomerName = customerName;
		Email = email;
		this.username = username;
		Password = password;
		PhoneNumber = phoneNumber;
		AccountType = accountType;
		this.account = account;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [Cusomterid=" + Cusomterid + ", CustomerName=" + CustomerName + ", Email=" + Email
				+ ", username=" + username + ", Password=" + Password + ", PhoneNumber=" + PhoneNumber
				+ ", AccountType=" + AccountType + ", account=" + account + "]";
	}


}