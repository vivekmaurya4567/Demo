package com.freecharge.demo1.service;


import com.freecharge.demo1.request.BookDeleteRequest;
import com.freecharge.demo1.request.BookInsertRequest;
import com.freecharge.demo1.request.BookUpdateRequest;
import com.freecharge.demo1.response.BookByIdResponse;
import com.freecharge.demo1.response.BookInsertResponse;
import com.freecharge.demo1.response.BookListResponse;
import com.freecharge.demo1.response.BookUpdateOrDeleteResponse;


public interface IBookService 
{
	public BookInsertResponse insertBook(BookInsertRequest bookRequest);

	public BookByIdResponse getBookById(long id);

	public BookListResponse getAllBooks();

	public BookUpdateOrDeleteResponse updateBook(BookUpdateRequest newDetails);

	
	public BookUpdateOrDeleteResponse deleteBook(BookDeleteRequest deleteById);

}
