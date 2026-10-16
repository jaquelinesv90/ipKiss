package dto;

import com.ebanx.enums.EventType;

public class EventRequest {

	private EventType type;
	private String destination;
	private Integer amount;
	
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
}
