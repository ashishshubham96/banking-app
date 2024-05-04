package com.dbs.accountmanagement.model;

public class AccountDeletionResponse {

	private Long accountId;
	
	private String successfulMessage;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getSuccessfulMessage() {
		return successfulMessage;
	}

	public void setSuccessfulMessage(String successfulMessage) {
		this.successfulMessage = successfulMessage;
	}
	
	
	
}
