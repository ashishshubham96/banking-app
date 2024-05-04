package com.dbs.accountmanagement.util;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.dbs.accountmanagement.entity.Account;
import com.dbs.accountmanagement.model.AccountDetails;
import com.dbs.accountmanagement.model.AccountForm;
import com.dbs.accountmanagement.model.UpdationForm;

@Component
public class AccountUtil {
	
	public AccountDetails mapAccountToAccountDetails(Account account) {
		AccountDetails accountDetails = new AccountDetails();
		accountDetails.setAccountNumber(account.getAccountNumber());
		accountDetails.setAccountType(account.getAccountType());
		accountDetails.setEmaiId(account.getEmailId());
		accountDetails.setBalance(account.getBalance());
		accountDetails.setCustomerName(account.getCustomerName());
		accountDetails.setCreationTime(account.getCreationTime());
		accountDetails.setUpdationTime(account.getUpdationTime());
		
		return accountDetails;
	}
	
	public Account updateAccount(UpdationForm updationForm, Account account) {
		if(updationForm.getAccountType() != null) {
			account.setAccountType(updationForm.getAccountType().toString());
		}
		if(updationForm.getBalance() != null) {
			account.setBalance(updationForm.getBalance());
		}
		if(updationForm.getEmailId() != null) {
			account.setEmailId(updationForm.getEmailId());
		}
		if(updationForm.getFullname() != null) {
			account.setCustomerName(updationForm.getFullname());
		}
		account.setUpdationTime(LocalDateTime.now());
		return account;
	}

}
