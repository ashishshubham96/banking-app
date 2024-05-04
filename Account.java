package com.dbs.accountmanagement.entity;


import java.time.LocalDateTime;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "account")
public class Account {
	
	@Id
	@Column(name = "account_number")
	private Long accountNumber;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "account_type")
	private String accountType;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "balance")
	private Double balance;
	
	@Column(name = "creation_time")
	private LocalDateTime creationTime;
	
	@Column(name = "updation_time")
	private LocalDateTime updationTime;

	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
