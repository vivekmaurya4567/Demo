package com.freecharge.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.freecharge.demo1.DemoConstants;
import com.freecharge.demo1.request.BookDeleteRequest;
import com.freecharge.demo1.request.BookInsertRequest;
import com.freecharge.demo1.request.BookUpdateRequest;
import com.freecharge.demo1.response.BookByIdResponse;
import com.freecharge.demo1.response.BookInsertResponse;
import com.freecharge.demo1.response.BookListResponse;
import com.freecharge.demo1.response.BookUpdateOrDeleteResponse;
import com.freecharge.demo1.service.IBookService;

@RestController
@RequestMapping(path=DemoConstants.BASE_URL_BOOK)
public class BookController extends ResponseEntityExceptionHandler
{
	private IBookService bookService;
	
	@Autowired
	public BookController(IBookService bookService) {
		super();
		this.bookService = bookService;
	}
	
		//API To Create a new BOOK record
		@PostMapping(path=DemoConstants.BOOK_INSERT_URL,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
		public BookInsertResponse insertBook(@RequestBody BookInsertRequest book)
		{
			return bookService.insertBook(book);
		}
		
		//API to Get ALL BOOK RECORD
		@ResponseBody
		@GetMapping(path=DemoConstants.BOOK_GET_ALL_URL,produces=MediaType.APPLICATION_JSON_VALUE)
		public BookListResponse getAllBooks()
		{
			return bookService.getAllBooks();
		}
		
		//API to get BOOK using id 
		@ResponseBody
		@GetMapping(path=DemoConstants.BOOK_GET_BY_ID_URL,produces=MediaType.APPLICATION_JSON_VALUE)
		public BookByIdResponse getBookById(@RequestParam long id)
		{
			return bookService.getBookById(id);
		}
		
		//API To Update Book record
		@ResponseBody
		@PutMapping(path =DemoConstants.BOOK_UPDATE_URL,produces=MediaType.APPLICATION_JSON_VALUE)
		public BookUpdateOrDeleteResponse updateBook(@RequestBody BookUpdateRequest newDetails) 
		{
			return bookService.updateBook(newDetails);
		}
		
			
		//API to Delete Book Record
		@ResponseBody
		@DeleteMapping(path = DemoConstants.BOOK_DELETE_URL,produces=MediaType.APPLICATION_JSON_VALUE)
		public BookUpdateOrDeleteResponse deleteBook(@RequestBody BookDeleteRequest deleteById)
		{
			return bookService.deleteBook(deleteById);
		}
}
