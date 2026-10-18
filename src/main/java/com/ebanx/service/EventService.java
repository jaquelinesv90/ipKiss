package com.ebanx.service;

import java.math.BigDecimal;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.stereotype.Service;

import com.ebanx.dto.EventRequest;
import com.ebanx.dto.EventResponse;
import com.ebanx.enums.EventType;
import com.ebanx.model.Account;
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
	
	
	public Account deposit(EventRequest request) {
		
		Account account = accountRepository.findByAccountNumber(request.getDestination())
				.orElse(new Account());
       if(account.getAccountNumber() != null) {
    	   account.setBalance(account.getBalance().add(BigDecimal.valueOf(request.getAmount())));
       }else {
    	   account.setAccountNumber(request.getDestination());
    	   account.setBalance(BigDecimal.valueOf(request.getAmount()));
       }
       accountRepository.deposit(account);
		
		return account;
	}
	 
	
	public Account withdraw(EventRequest request) {
		
		Account account = accountRepository.findByAccountNumber(request.getOrigin())
				.orElse(new Account());
		
		if(account.getAccountNumber() != null) {
			account.setBalance(account.getBalance().subtract(BigDecimal.valueOf(request.getAmount())));
		}else {
			return null;
		}
		accountRepository.
		return account;
		
	}
	
	
	public EventResponse transfer(EventRequest request) throws AccountNotFoundException {
			
		Account origin = accountRepository.findByAccountNumber(request.getOrigin())
				.orElseThrow(() -> new AccountNotFoundException("Account not found"));
		
		//BigDecimal amount = BigDecimal.valueOf(request.getAmount());
		
		Account destination = accountRepository.findByAccountNumber(request.getDestination())
				.orElseThrow(() -> new AccountNotFoundException("Account not found"));
		
		EventResponse response = new EventResponse();
		
		request.setOrigin(origin.getAccountNumber());
		request.setDestination(destination.getAccountNumber());
		
		withdraw(request);
		deposit(request);
		
		return response;
	}
}
