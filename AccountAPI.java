package com.dbs.accountmanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.accountmanagement.Constant.AccountConstantErrorCode;
import com.dbs.accountmanagement.Constant.AccountConstantErrorMessage;
import com.dbs.accountmanagement.exception.AccountManagementException;
import com.dbs.accountmanagement.exception.ControllerException;
import com.dbs.accountmanagement.model.AccountCreationResponse;
import com.dbs.accountmanagement.model.AccountDeletionResponse;
import com.dbs.accountmanagement.model.AccountDetails;
import com.dbs.accountmanagement.model.AccountForm;
import com.dbs.accountmanagement.model.UpdationForm;
import com.dbs.accountmanagement.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/dbs/account")
@ComponentScan
public class AccountAPI {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createAccount(@Valid @RequestBody AccountForm accountForm){
		
		AccountCreationResponse accountCreationResponse = new AccountCreationResponse();
		accountCreationResponse = accountService.createAccount(accountForm);
		return new ResponseEntity<>(accountCreationResponse, HttpStatus.OK);
	}
	
	@GetMapping("/accountdetails/{accountNumber}")
	public ResponseEntity<?> accountDetails(@PathVariable Long accountNumber){
		AccountDetails accountDetails = new AccountDetails();
		accountDetails = accountService.getAccountDetails(accountNumber);
		
		return new ResponseEntity<>(accountDetails, HttpStatus.OK);
	}
	
	@PutMapping("/updateaccount/{accountNumber}")
	public ResponseEntity<?> accountDetails(@PathVariable Long accountNumber, @Valid @RequestBody UpdationForm updationForm){
		AccountDetails accountDetails = new AccountDetails();
		accountDetails = accountService.updateAccountDetails(accountNumber,updationForm);
		return new ResponseEntity<>(accountDetails, HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{accountNumber}")
	public ResponseEntity<?> accountDelete(@PathVariable Long accountNumber){
		AccountDeletionResponse accountDeletionResponse = new AccountDeletionResponse();
		
		accountDeletionResponse = accountService.deleteAccount(accountNumber);
		return new ResponseEntity<>(accountDeletionResponse, HttpStatus.OK);
	}
}
