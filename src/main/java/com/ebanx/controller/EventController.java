package com.ebanx.controller;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebanx.dto.AccountResponse;
import com.ebanx.dto.EventRequest;
import com.ebanx.dto.EventResponse;
import com.ebanx.model.Account;
import com.ebanx.service.EventService;

@RestController
@RequestMapping(value = "/event")
public class EventController {
	
	private final EventService eventService;
	
	public EventController(EventService eventService) {
		this.eventService = eventService;
	}
	
	@PostMapping
	public ResponseEntity<?> handleMethod(@RequestBody EventRequest request) 
						throws AccountNotFoundException {
		return switch(request.getType()) {
			case DEPOSIT -> deposit(request);
			case WITHDRAW -> withdraw(request);
			case TRANSFER -> transfer(request);
		};
	}
	
	public ResponseEntity<EventResponse> deposit(EventRequest request) {
		
		Account account = eventService.deposit(request);
		
		EventResponse response = new EventResponse(
				null, new AccountResponse(account.getAccountNumber(), account.getBalance()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	
	public ResponseEntity<?> withdraw(EventRequest request) {
		
		Account account = eventService.withdraw(request);
		
		if(account != null) {
			EventResponse response = new EventResponse(
				new AccountResponse(account.getAccountNumber(), 
						account.getBalance()), null);
		
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
	
	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("0");
	}
	
	
	public ResponseEntity<EventResponse> transfer(EventRequest request) {
		
		EventResponse response = new EventResponse();
		
		try {
			response = eventService.transfer(request);
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		}
				
		/*
		EventResponse response = new EventResponse(
				new AccountResponse(), new AccountResponse(account.getAccountNumber(), account.getBalance()));*/
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
}
