package com.ebanx.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ebanx.model.Account;

@Repository
public class AccountRepository {
	
	private final List<Account> accounts = new ArrayList<>();
	
	public void reset() {
		accounts.clear();
	}
	
	public Account deposit(Account account) {
		accounts.add(account);
		return account;
	}
	
	public Account update(Account account) {
		for (int i = 0; i < accounts.size(); i++) {
		   if (accounts.get(i).getAccountNumber().equals(account.getAccountNumber())) {
		       accounts.set(i, account);  
		       return account;
		    }
		}
		return null; 
	}
	
	
	public Optional<Account> findByAccountNumber(String accountNumber) {
		return accounts.stream()
				.filter( a -> a.getAccountNumber().contains(accountNumber))
				.findFirst();
	}
	
	public Account getBalance(String accountNumber) {
		return accounts.stream()
				.filter(a -> a.getAccountNumber().equals(accountNumber))
				.findFirst().get();
	}
	
}
