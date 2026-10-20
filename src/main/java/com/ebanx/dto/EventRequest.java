package com.ebanx.dto;

import java.math.BigDecimal;

import com.ebanx.enums.EventType;

public class EventRequest {

	private EventType type;
	private BigDecimal amount;
	private String destination;
	private String origin;
	
	public EventRequest() {}

	
	public EventType getType() {
		return type;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public String getDestination() {
		return destination;
	}
	public String getOrigin() {
		return origin;
	}
	public void setType(EventType type) {
		this.type = type;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
}
