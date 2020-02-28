package com.freecharge.demo1.dao.impl;


import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.freecharge.demo1.dao.IBookRepositoryDao;
import com.freecharge.demo1.exception.BookInsertException;
import com.freecharge.demo1.exception.BookNotFoundException;
import com.freecharge.demo1.exception.StudentInsertException;
import com.freecharge.demo1.model.BookEntity;

import com.freecharge.demo1.repository.BookRepository;


@Component
public class BookRespositoryDaoImpl implements IBookRepositoryDao{
    private BookRepository bookRepository;
	
    
    @Autowired
    public BookRespositoryDaoImpl(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
		
	}
    @Override
    @Transactional
    public long insertBook(BookEntity bookEntity)
    {
	    try {
	    	BookEntity book =bookRepository.save(bookEntity);
	  	    return book.getId(); 
	    	}
	    catch(BookInsertException ex)
		{
			throw new StudentInsertException("Book details are wrong.");
		}
		catch(Exception ex)
		{
			throw new StudentInsertException("RuntimeException during insert operation.");
		}
	 }
	@Override
	@Transactional
	public BookEntity getBookById(long id) 
	{
		
		try {
				Optional<BookEntity> bookEntity = bookRepository.findById(id);
				if(bookEntity.isPresent())
				{
					return bookEntity.get();
				}
				else
				{
					throw new BookNotFoundException("Book record with "+id+" not found.");	
				}
		}
		catch(Exception ex)
		{
			throw new BookNotFoundException("RuntimeException during getById operation.");
		}
	}
	@Override
	@Transactional
	public List<BookEntity> getAllBooks() 
	{
		try {
				if(bookRepository.findAll()!=null)
				return bookRepository.findAll();
				else throw new BookNotFoundException("Book records not found");
		}
		catch(Exception ex)
		{
			throw new BookNotFoundException("RuntimeException during getAllBooks operation.");
		}
	}
	@Override
	@Transactional
	public long updateBook(BookEntity bookEntity) 
	{

	    try {
	    		BookEntity book =bookRepository.save(bookEntity);
	    		return book.getId(); 
	    	}
	    catch(BookInsertException ex)
		{
			throw new StudentInsertException("Book details are wrong.");
		}
		catch(Exception ex)
		{
			throw new StudentInsertException("RuntimeException during update operation.");
		}
	}
	@Override
	@Transactional
	public long deleteBook(BookEntity bookEntity) 
	{
		try {
				bookRepository.delete(bookEntity);
				return bookEntity.getId();
		}
		catch(Exception ex)
		{
			throw new StudentInsertException("RuntimeException during delete operation.");
		}
	}
	
    
}
