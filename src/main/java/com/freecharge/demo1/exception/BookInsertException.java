package com.freecharge.demo1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class BookInsertException extends RuntimeException
{
	public BookInsertException(String message) 
	{
		super(message);
	}
}
