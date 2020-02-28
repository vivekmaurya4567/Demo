package com.freecharge.demo1.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.freecharge.demo1.dao.IBookRepositoryDao;
import com.freecharge.demo1.model.BookEntity;
import com.freecharge.demo1.request.BookDeleteRequest;
import com.freecharge.demo1.request.BookInsertRequest;
import com.freecharge.demo1.request.BookUpdateRequest;
import com.freecharge.demo1.response.BookByIdResponse;
import com.freecharge.demo1.response.BookInsertResponse;
import com.freecharge.demo1.response.BookListResponse;
import com.freecharge.demo1.response.BookUpdateOrDeleteResponse;
import com.freecharge.demo1.service.IBookService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookServiceImpl implements IBookService
{
	private IBookRepositoryDao bookDao;
	
	@Autowired
	public BookServiceImpl(IBookRepositoryDao bookDao)
	{
		this.bookDao=bookDao;
	}
	
	@Override
	@Transactional
	public BookInsertResponse insertBook(BookInsertRequest bookRequest)
	{
		BookEntity bookEntity = new BookEntity();
		
		BeanUtils.copyProperties(bookRequest, bookEntity);
		
		
		long id = bookDao.insertBook(bookEntity);
		
		log.info("Book entity details:{}",bookEntity.toString());
		bookEntity.setBookCount(bookEntity.getBookCount()+1);
		
		BookInsertResponse response = new BookInsertResponse();
		response.setResult("Book is successfully inserted at "+id);
		return response;
	}

	@Override
	@Transactional
	public BookByIdResponse getBookById(long id)
	{
		BookByIdResponse response = new BookByIdResponse();
		
		BookEntity bookEntity = bookDao.getBookById(id);	
			response.setResult("Book Record Found:");
			response.setId(bookEntity.getId());
			response.setName(bookEntity.getName());
		
		return response;
	}

	@Override
	@Transactional
	public BookListResponse getAllBooks() 
	{
		BookListResponse response = new BookListResponse();
		List<BookEntity> arr=bookDao.getAllBooks();	
			response.setArr(arr);
		
		return response;
	}

	@Override
	@Transactional
	public BookUpdateOrDeleteResponse updateBook(BookUpdateRequest newDetails) 
	{
		BookUpdateOrDeleteResponse response = new BookUpdateOrDeleteResponse();
		
		long id = newDetails.getId();
		BookEntity book = bookDao.getBookById(id);
		
		book.setName(newDetails.getName());
		book.setAuthorName(newDetails.getAuthorName());
		book.setBookCount(newDetails.getBookCount());
				
		id = bookDao.updateBook(book);
		
		log.info("Book entity details:{}",book.toString());
		
		response.setResult("update Succesfull");
		response.setName(book.getName());
		response.setId(id);
		return response;
	}

	@Override
	@Transactional
	public BookUpdateOrDeleteResponse deleteBook(BookDeleteRequest deleteById) 
	{
		BookUpdateOrDeleteResponse response = new BookUpdateOrDeleteResponse();
		long id =deleteById.getId();
		
		BookEntity book = bookDao.getBookById(id);
		
		id = bookDao.deleteBook(book);
		
		log.info("Book entity details:{}",book.toString());
		
		response.setResult("delete Succesfull");
		response.setName(book.getName());
		response.setId(id);
		return response;
	}

}
