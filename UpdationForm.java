package com.dbs.accountmanagement.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public class UpdationForm {

    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Full name should only contain letters and spaces")
	private String fullname;
	
	private AccountType accountType;
	
	@Email(message = "Proper email id is required")
	private String emailId;
	
    private Double balance;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
    
    
}
