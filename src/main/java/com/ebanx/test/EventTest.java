package com.ebanx.test;

import java.util.Scanner;

import com.ebanx.repository.AccountRepository;

public class EventTest {
	
	private AccountRepository repository;
	
	//@BeforeEach
	public void setUp() {
		repository = new AccountRepository();
	}
	
	//@Test
	public void getBalanceforExistingAccount() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the account number");	
		String accountNumber = String.valueOf(scanner.nextInt());
		
		repository.getBalance(accountNumber);
		
		//assertTrue();
	}
	
	
	//@Test
	public void getBalanceforNonExistingAccount() {
		
	}

}
