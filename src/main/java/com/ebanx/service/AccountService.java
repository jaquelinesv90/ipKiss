package com.ebanx.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ebanx.model.Account;
import com.ebanx.repository.AccountRepository;

@Service
public class AccountService {

	private final AccountRepository accountRepository;
	
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public Optional<Account> accountExists(String accountNumber) {
		return accountRepository.findByAccountNumber(accountNumber);
	}
	
	
	public Account getBalance(String accountNumber) {
		return accountRepository.getBalance(accountNumber);
	}
	
}
