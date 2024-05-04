package com.dbs.accountmanagement.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.accountmanagement.Constant.AccountConstantErrorCode;
import com.dbs.accountmanagement.Constant.AccountConstantErrorMessage;
import com.dbs.accountmanagement.Constant.AccountConstantMessages;
import com.dbs.accountmanagement.entity.Account;
import com.dbs.accountmanagement.exception.AccountManagementException;
import com.dbs.accountmanagement.model.AccountCreationResponse;
import com.dbs.accountmanagement.model.AccountDeletionResponse;
import com.dbs.accountmanagement.model.AccountDetails;
import com.dbs.accountmanagement.model.AccountForm;
import com.dbs.accountmanagement.model.UpdationForm;
import com.dbs.accountmanagement.repository.AccountRepository;
import com.dbs.accountmanagement.util.AccountUtil;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AccountUtil accountUtil;
	
	@Override
	public AccountCreationResponse createAccount(AccountForm accountForm) {
		AccountCreationResponse accountCreationResponse = new AccountCreationResponse();
		Account account = new Account();
		
		try {
			account.setCustomerName(accountForm.getFullname());
			account.setAccountType(accountForm.getAccountType().toString());
			account.setBalance(accountForm.getBalance());
			account.setEmailId(accountForm.getEmailId());
			account.setCreationTime(LocalDateTime.now());
			account.setUpdationTime(LocalDateTime.now());
			
			Long accountNumber = accountRepository.getMaxAccountNumberOrDefault();
			account.setAccountNumber(accountNumber+1);
			
			account = accountRepository.save(account);
		}
		catch(Exception e){
			throw new AccountManagementException(AccountConstantErrorCode.errorInSaving, AccountConstantErrorMessage.errorInSaving);
		}
		accountCreationResponse.setAccountNumber(account.getAccountNumber());
		accountCreationResponse.setSuccessfullMessage(AccountConstantMessages.creationSuccess);
		
		return accountCreationResponse;
	}

	@Override
	public AccountDetails getAccountDetails(Long accountNumber) {
		AccountDetails accountDetails = new AccountDetails();
		
		Optional<Account> optional = accountRepository.findById(accountNumber);	
		if(optional.isEmpty()) {
			throw new AccountManagementException(AccountConstantErrorCode.accountNumberNotExist, AccountConstantErrorMessage.accountNumberNotExist);
		}
		accountDetails = accountUtil.mapAccountToAccountDetails(optional.get());
		return accountDetails;
	}

	@Override
	public AccountDetails updateAccountDetails(Long accountNumber, UpdationForm updationForm) {
		AccountDetails accountDetails = new AccountDetails();
		Optional<Account> optional = accountRepository.findById(accountNumber);
		if(optional.isEmpty()) {
			throw new AccountManagementException(AccountConstantErrorCode.accountNumberNotExist, AccountConstantErrorMessage.accountNumberNotExist);
		}
		try {
			Account account = accountUtil.updateAccount(updationForm, optional.get());
			accountRepository.updateAccount(accountNumber, account.getCustomerName(), account.getAccountType(), account.getBalance(), account.getUpdationTime());
			accountDetails = accountUtil.mapAccountToAccountDetails(account);
		}
		catch(Exception e) {
			throw new AccountManagementException(AccountConstantErrorCode.errorInUpdating, AccountConstantErrorMessage.errorInUpdating);
		}
		
		return accountDetails;
	}

	@Override
	public AccountDeletionResponse deleteAccount(Long accountNumber) {
		AccountDeletionResponse accountDeletionResponse = new AccountDeletionResponse();
		Optional<Account> optional = accountRepository.findById(accountNumber);
		if(optional.isEmpty()) {
			throw new AccountManagementException(AccountConstantErrorCode.accountNumberNotExist, AccountConstantErrorMessage.accountNumberNotExist);
		}
		try {
			accountRepository.deleteById(accountNumber);
			accountDeletionResponse.setAccountId(accountNumber);
		}
		catch(Exception e) {
			throw new AccountManagementException(AccountConstantErrorCode.errorInDeleting, AccountConstantErrorMessage.errorInDeleting);
		}
		
		accountDeletionResponse.setSuccessfulMessage(AccountConstantMessages.deleteSuccess);
		return accountDeletionResponse;
	}

}
