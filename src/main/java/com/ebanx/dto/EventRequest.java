package com.ebanx.dto;

import com.ebanx.enums.EventType;

public class EventRequest {

	private EventType type;
	private Integer amount;
	private String destination;
	private String origin;
	
	public EventRequest() {}
	
	public EventType getType() {
		return type;
	}
	public String getDestination() {
		return destination;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setType(EventType type) {
		this.type = type;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
}
