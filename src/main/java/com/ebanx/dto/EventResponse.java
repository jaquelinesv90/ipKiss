package com.ebanx.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventResponse {
	
	private AccountResponse origin;
	private AccountResponse destination;
	
	public EventResponse() {}
	
	public EventResponse(AccountResponse origin, AccountResponse destination) {
		this.origin = origin;
		this.destination = destination;
	}
	
	public AccountResponse getOrigin() {
		return origin;
	}
	public AccountResponse getDestination() {
		return destination;
	}
	public void setOrigin(AccountResponse origin) {
		this.origin = origin;
	}
	public void setDestination(AccountResponse destination) {
		this.destination = destination;
	}
}
