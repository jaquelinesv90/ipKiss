package com.ebanx.service;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.stereotype.Service;

import com.ebanx.dto.AccountResponse;
import com.ebanx.dto.EventRequest;
import com.ebanx.dto.EventResponse;
import com.ebanx.exception.InsufficientFundsException;
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
    	   account.setBalance(account.getBalance().add(request.getAmount()));
       }else {
    	   account.setAccountNumber(request.getDestination());
    	   account.setBalance(request.getAmount());
       }
       accountRepository.deposit(account);
		
		return account;
	}
	 
	
	public Account withdraw(EventRequest request) {
		
		Account account = accountRepository.findByAccountNumber(request.getOrigin())
				.orElse(new Account());
		
		if(account.getAccountNumber() != null) {
			account.setBalance(account.getBalance().subtract(request.getAmount()));
		}else {
			return null;
		}
		accountRepository.update(account);
		return account;
		
	}
	
	
	public EventResponse transfer(EventRequest request) throws AccountNotFoundException {

	    Account origin = accountRepository.findByAccountNumber(request.getOrigin()).orElse(null);

	    if (origin == null) {
	        throw new AccountNotFoundException("Account not found");   
	    }

	    if (origin.getBalance().compareTo(request.getAmount()) < 0) {
	        throw new InsufficientFundsException("Insufficient funds");
	    }

	    Account destination = accountRepository.findByAccountNumber(request.getDestination()).orElse(null);

	    if (destination == null) {
	        destination = accountRepository.deposit(new Account(request.getDestination(),request.getAmount()));
	    }

	    origin.setBalance(origin.getBalance().subtract(request.getAmount()));
	    destination.setBalance(destination.getBalance().add(request.getAmount()));


	    return new EventResponse(
	            new AccountResponse(origin.getAccountNumber(), origin.getBalance()),
	            new AccountResponse(destination.getAccountNumber(), destination.getBalance()));
	}

}
