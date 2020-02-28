package com.freecharge.demo1.exception.response;

import java.util.Date;

public class BookNotFoundExceptionResponse
{
	private Date timestamp;
	private String message;
	private String httpCodeMessage;
	private String details;
	
	public BookNotFoundExceptionResponse(Date timestamp, String message, String httpCodeMessage, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.httpCodeMessage = httpCodeMessage;
		this.details = details;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getHttpCodeMessage() {
		return httpCodeMessage;
	}
	public String getDetails() {
		return details;
	}
}
