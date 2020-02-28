package com.freecharge.demo1.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.freecharge.demo1.exception.response.BookExceptionResponse;
import com.freecharge.demo1.exception.response.BookNotFoundExceptionResponse;
import com.freecharge.demo1.exception.response.StudentExceptionResponse;
import com.freecharge.demo1.exception.response.StudentNotFoundExceptionResponse;
import com.freecharge.demo1.exception.response.TransactionExceptionResponse;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(StudentNotFoundException.class)
	  public final ResponseEntity<StudentNotFoundExceptionResponse> handleStudentNotFoundException(StudentNotFoundException ex, WebRequest request) {
		StudentNotFoundExceptionResponse errorDetails = new StudentNotFoundExceptionResponse(new Date(), ex.getMessage(),
	        request.getDescription(false),HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }
	  
	@ExceptionHandler(BookNotFoundException.class)
	  public final ResponseEntity<BookNotFoundExceptionResponse> handleBookNotFoundException(StudentNotFoundException ex, WebRequest request) {
		BookNotFoundExceptionResponse errorDetails = new BookNotFoundExceptionResponse(new Date(), ex.getMessage(),
	        request.getDescription(false),HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }
	
	@ExceptionHandler(StudentInsertException.class)
		public final ResponseEntity<StudentExceptionResponse> handleStudentInsertException(StudentInsertException ex, WebRequest request) {
		StudentExceptionResponse errorDetails = new StudentExceptionResponse(new Date(), ex.getMessage());
	    return new ResponseEntity<>(errorDetails, HttpStatus.NO_CONTENT);
	  }
	
	@ExceptionHandler(BookInsertException.class)
		public final ResponseEntity<BookExceptionResponse> handleBookInsertException(BookInsertException ex, WebRequest request) {
		BookExceptionResponse errorDetails = new BookExceptionResponse(new Date(), ex.getMessage());
	    return new ResponseEntity<>(errorDetails, HttpStatus.NO_CONTENT);
		}
	@ExceptionHandler(TransactionException.class)
		public final ResponseEntity<TransactionExceptionResponse> handleTransactionException(TransactionException ex,WebRequest request)
		{
			TransactionExceptionResponse errorDetails = new TransactionExceptionResponse(new Date(), ex.getMessage(),
		        request.getDescription(false),HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
			return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
		}
		
	@ExceptionHandler(Exception.class)
		  public final ResponseEntity<StudentNotFoundExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
			StudentNotFoundExceptionResponse errorDetails = new StudentNotFoundExceptionResponse(new Date(), ex.getMessage(),
		        request.getDescription(false),HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
		    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	
}
