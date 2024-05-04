package com.dbs.accountmanagement.model;

public class AccountCreationResponse {

	private Long accountNumber;
	
	private String successfulMessage;

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getSuccessfulMessage() {
		return successfulMessage;
	}

	public void setSuccessfullMessage(String successfulMessage) {
		this.successfulMessage = successfulMessage;
	}
	
	
}
