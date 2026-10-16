package com.ebanx.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EventType {
	
	@JsonProperty("deposit") DEPOSIT,
	@JsonProperty("withdraw") WITHDRAW,
	@JsonProperty("transfer") TRANSFER

	
}
