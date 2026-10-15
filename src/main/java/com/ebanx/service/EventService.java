package com.ebanx.service;

import org.springframework.stereotype.Service;

import com.ebanx.repository.AccountRepository;

@Service
public class EventService {
	
	private AccountRepository accountRepository;
	
	public EventService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public void reset() {
		accountRepository.reset();
	}

}
