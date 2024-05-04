package com.dbs.accountmanagement.model;

import java.time.LocalDateTime;

public class AccountDetails {

	private Long accountNumber;
	
	private String customerName;
	
	private String accountType;
	
	private String emaiId;
	
	private Double balance;
	
	private LocalDateTime creationTime;
	
	private LocalDateTime updationTime;

	
	public String getEmaiId() {
		return emaiId;
	}

	public void setEmaiId(String emaiId) {
		this.emaiId = emaiId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public LocalDateTime getUpdationTime() {
		return updationTime;
	}

	public void setUpdationTime(LocalDateTime updationTime) {
		this.updationTime = updationTime;
	}
	
	
}
