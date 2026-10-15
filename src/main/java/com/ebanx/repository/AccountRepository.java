package com.ebanx.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ebanx.model.Account;

@Repository
public class AccountRepository {
	
	private final List<Account> accounts = new ArrayList<>();
	
	public void reset() {
		accounts.clear();
	}
	
	public void createAccount(Account account) {
		accounts.add(account);
	}
	
	public Account accountExists(String accountNumber) {
		return accounts.stream()
				.filter( a -> a.getAccountNumber().contains(accountNumber))
				.findFirst()
				.orElse(null);
	}
	
	public Account getBalance(String accountNumber) {
		return accounts.stream()
				.filter(a -> a.getAccountNumber().equals(accountNumber))
				.findFirst().get();
	}

}
