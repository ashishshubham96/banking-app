package com.dbs.accountmanagement.service;

import org.springframework.stereotype.Service;

import com.dbs.accountmanagement.model.AccountCreationResponse;
import com.dbs.accountmanagement.model.AccountDeletionResponse;
import com.dbs.accountmanagement.model.AccountDetails;
import com.dbs.accountmanagement.model.AccountForm;
import com.dbs.accountmanagement.model.UpdationForm;

@Service
public interface AccountService {

	public AccountCreationResponse createAccount(AccountForm accountForm);
	
	public AccountDetails getAccountDetails(Long accountNumber);
	
	public AccountDetails updateAccountDetails(Long accountNumber, UpdationForm updationForm);
	
	public AccountDeletionResponse deleteAccount(Long accountNumber);
}
