package com.freecharge.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.freecharge.demo1.DemoConstants;
import com.freecharge.demo1.exception.CustomizedResponseEntityExceptionHandler;
import com.freecharge.demo1.exception.TransactionException;

import com.freecharge.demo1.request.BookIssueRequest;
import com.freecharge.demo1.request.BookSubmitRequest;

import com.freecharge.demo1.request.StudentDeleteRequest;
import com.freecharge.demo1.request.StudentRequest;
import com.freecharge.demo1.request.StudentUpdateRequest;

import com.freecharge.demo1.response.BookIssueResponse;

import com.freecharge.demo1.response.BookSubmitResponse;

import com.freecharge.demo1.response.StudentInsertResponse;
import com.freecharge.demo1.response.StudentListResponse;
import com.freecharge.demo1.response.StudentResponse;
import com.freecharge.demo1.response.transactionListResponse;

import com.freecharge.demo1.service.IStudentService;
import com.freecharge.demo1.service.ITransactionService;

@RestController
@RequestMapping(path=DemoConstants.BASE_URL_STUDENT)
public class StudentController extends CustomizedResponseEntityExceptionHandler{

	private IStudentService studentService;
	private ITransactionService transactionService;
	
	@Autowired
	public StudentController(IStudentService studentService,ITransactionService transactionService) 
	{
		this.studentService=studentService;
		this.transactionService = transactionService;
	}
	
	//API To Create a new STUDENT record
	@PostMapping(path = DemoConstants.STUDENT_INSERT_URL,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public StudentInsertResponse insertStudent(@RequestBody StudentRequest student)
	{
		return studentService.insertStudent(student);		
	}
	
	//API to get STUDENT using id 
	@ResponseBody
	@RequestMapping(value=DemoConstants.STUDENT_GET_BY_ID_URL,method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentResponse getStudentById(@RequestParam long id) 
	{
		return studentService.getStudentById(id);
	}
	
	//API to Get ALL STUDENT RECORD
	@ResponseBody
	@GetMapping(path=DemoConstants.STUDENT_GET_ALL_URL,produces=MediaType.APPLICATION_JSON_VALUE)
	public StudentListResponse getAllStudents()
	{
		return studentService.getAllStudents();
	}

	//API To Update student Record
	@ResponseBody
	@PutMapping(path = DemoConstants.STUDENT_UPDATE_URL,produces=MediaType.APPLICATION_JSON_VALUE)
	public StudentResponse updateStudent(@RequestBody StudentUpdateRequest newDetails) 
	{
		return studentService.updateStudent(newDetails);
	}
	
	//API to Delete student record
	@ResponseBody
	@DeleteMapping(path = DemoConstants.STUDENT_DELETE_URL,produces=MediaType.APPLICATION_JSON_VALUE)
	public StudentResponse deleteStudent(@RequestBody StudentDeleteRequest deleteById)
	{
		return studentService.deleteStudent(deleteById);
	}
	
	//API to ISSUE a Book
	@PostMapping(path = DemoConstants.BOOK_ISSUE_URL,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public BookIssueResponse issueBook(@RequestBody BookIssueRequest request) throws TransactionException
	{
			return transactionService.issueBook(request);
	}
		
	//API to SUBMIT a BOOK
	@PostMapping(path = DemoConstants.BOOK_SUBMIT_URL,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public BookSubmitResponse submitBook(@RequestBody BookSubmitRequest request) throws TransactionException
	{
			return transactionService.submitBook(request);
	}
		
	//API To get All transaction Record
	@ResponseBody
	@GetMapping(path = DemoConstants.TRANSACTION_ALL_URL,produces = MediaType.APPLICATION_JSON_VALUE)
	public transactionListResponse getAllTransactions()
	{
			return transactionService.getAllTransactions();
	}
}