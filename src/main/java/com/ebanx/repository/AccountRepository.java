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

}
