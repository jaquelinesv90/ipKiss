package com.ebanx.service;

import org.springframework.stereotype.Service;

import com.ebanx.model.Account;
import com.ebanx.repository.AccountRepository;

@Service
public class AccountService {

	private final AccountRepository accountRepository;
	
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public Account accountExists(String accountNumber) {
		return accountRepository.accountExists(accountNumber);
	}
	
	
	public Account getBalance(String accountNumber) {
		return accountRepository.getBalance(accountNumber);
	}
	
	
	public void addBalance(Account account) {
		
	}
	
}
