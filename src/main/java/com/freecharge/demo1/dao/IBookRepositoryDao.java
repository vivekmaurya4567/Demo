package com.freecharge.demo1.dao;


import java.util.List;

import com.freecharge.demo1.model.BookEntity;


public interface IBookRepositoryDao 
{

	public long insertBook(BookEntity bookEntity);

	public BookEntity getBookById(long id);

	public List<BookEntity> getAllBooks();

	public long updateBook(BookEntity book);

	public long deleteBook(BookEntity book);
	
}
