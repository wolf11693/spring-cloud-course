package com.xantrix.webapp.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ResponseBody<T extends ResponsePayload> implements Serializable {
	private static final long serialVersionUID = 4065373345181358837L;
	
	private LocalDateTime dateTime = LocalDateTime.now();
	private List<String> messages = new ArrayList<>();
	private T payload = null;

	
	public ResponseBody(T payload) {
		super();
		this.payload = payload;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Response [dateTime=");
		builder.append(dateTime);
		builder.append(", messages=");
		builder.append(messages);
		builder.append(", payload=");
		builder.append(payload);
		builder.append("]");
		return builder.toString();
	}
}