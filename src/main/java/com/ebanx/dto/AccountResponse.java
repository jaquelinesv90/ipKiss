package com.ebanx.dto;

import java.math.BigDecimal;

public class AccountResponse {
	
	private String id;
	private BigDecimal balance;
	
	public AccountResponse(String id, BigDecimal balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	
	public String getId() {
		return id;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
