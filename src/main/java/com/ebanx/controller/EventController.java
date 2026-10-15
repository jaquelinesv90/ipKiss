package com.ebanx.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ebanx.enums.EventType;
import com.ebanx.service.EventService;

@RestController
@RequestMapping(value = "/event")
public class EventController {
	
	private final EventService eventService;
	
	public EventController(EventService eventService) {
		this.eventService = eventService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> createAccountWithBalance(@RequestBody EventType eventType,
			String destination, String amount) {
		return null;
		//return eventService.createAccount();
	}

}
