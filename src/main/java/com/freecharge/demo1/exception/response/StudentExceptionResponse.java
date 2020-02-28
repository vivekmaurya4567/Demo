package com.freecharge.demo1.exception.response;

import java.util.Date;

public class StudentExceptionResponse 
{
	private Date timestamp;
	private String message;
	public StudentExceptionResponse(Date timestamp, String message) {
		super();
		this.timestamp = timestamp;
		this.message = message;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
}
