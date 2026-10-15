package com.ebanx.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebanx.model.Account;
import com.ebanx.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/balance")
public class AccountController {
	
	private AccountService accountService;
	
	public AccountController(AccountService balanceService) {
		this.accountService =  balanceService;
	}	
	
		
	@GetMapping
	public ResponseEntity<String> getBalance(
			@Valid @RequestParam("account_id") String accountNumber) {
		
		Account account = accountService.accountExists(accountNumber);
		
		if(account == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("0");
		}
		return ResponseEntity.status(HttpStatus.OK).body(account.getBalance());
	}

}
