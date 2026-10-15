package com.ebanx.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ebanx.service.EventService;

@RestController
@RequestMapping(value = "/reset")
public class ResetController {
	
	private final EventService eventService;
	
	public ResetController(EventService eventService) {
		this.eventService = eventService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void reset() {
		eventService.reset();
	}
}
