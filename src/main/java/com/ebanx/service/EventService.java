package com.ebanx.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.ebanx.enums.EventType;
import com.ebanx.model.Account;
import com.ebanx.repository.AccountRepository;

import dto.EventRequest;

@Service
public class EventService {
	
	private AccountRepository accountRepository;
	
	public EventService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public Account createAccount(EventRequest request) {
		
		Account account = accountRepository.accountExists(request.getDestination());
					
		//se a conta ja existe tem que somar o valor, senao 
		if(account != null && request.getType().equals(EventType.DEPOSIT)) {
			account.getBalance().add(BigDecimal.valueOf(request.getAmount()));
		}else {
			account = new Account();
			account.setAccountNumber(request.getDestination());
			account.setBalance(BigDecimal.valueOf(request.getAmount()));
		}
		return accountRepository.createAccount(account);
	}
	
	
	public void reset() {
		accountRepository.reset();
	}
	

}
