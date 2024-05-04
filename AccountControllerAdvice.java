package com.dbs.accountmanagement.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dbs.accountmanagement.Constant.AccountConstantErrorCode;
import com.dbs.accountmanagement.Constant.AccountConstantErrorMessage;
import com.dbs.accountmanagement.exception.AccountManagementException;
import com.dbs.accountmanagement.exception.ControllerException;

@ControllerAdvice
public class AccountControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> invalidInput(MethodArgumentNotValidException e){
		ControllerException controllerException = new ControllerException(AccountConstantErrorCode.invalidRequest, AccountConstantErrorMessage.invalidRequest);
		return new ResponseEntity<>(controllerException,HttpStatus.BAD_REQUEST );
	}
	
	@ExceptionHandler(AccountManagementException.class)
	public ResponseEntity<?> accountManagementException(AccountManagementException e){
		ControllerException controllerException = new ControllerException(e.getErrorCode(), e.getErrorMessage());
		return new ResponseEntity<>(controllerException,HttpStatus.BAD_REQUEST );
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> excpetion(Exception e){
		ControllerException controllerException = new ControllerException(AccountConstantErrorCode.somethingWentWrong, AccountConstantErrorMessage.somethingWentWrong);
		return new ResponseEntity<>(controllerException,HttpStatus.BAD_REQUEST );
	}
}
