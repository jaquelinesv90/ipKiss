package com.ebanx.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ebanx.model.Account;
import com.ebanx.repository.AccountRepository;

@Service
public class EventService {
	
	private AccountRepository accountRepository;
	
	public EventService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public ResponseEntity<Void> createAccount(Account account) {
		if(account.getAccountNumber().equals("")) {
			return ResponseEntity.badRequest().build();
		}
		accountRepository.createAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
	public void reset() {
		accountRepository.reset();
	}
	
	/*
	public boolean accountExists(String accountNumber) {
		return accountRepository.accountExists(accountNumber);
	}*/

}
