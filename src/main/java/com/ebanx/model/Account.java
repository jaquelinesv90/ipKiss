package com.ebanx.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Account {
	
	@NotNull
	@Min(0)
	private String accountNumber;
	
	@NotNull
	@Min(0)
	private String balance;

	public Account(String accountNumber, String balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getBalance() {
		return balance;
	}
	
}
