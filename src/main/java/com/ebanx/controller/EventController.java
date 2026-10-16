package com.ebanx.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebanx.service.EventService;

import dto.EventRequest;

@RestController
@RequestMapping(value = "/event")
public class EventController {
	
	private final EventService eventService;
	
	public EventController(EventService eventService) {
		this.eventService = eventService;
	}
	
	@PostMapping
	public ResponseEntity<EventRequest> create(@RequestBody EventRequest request) {
		
		eventService.createAccount(request);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(request);
	}

}
