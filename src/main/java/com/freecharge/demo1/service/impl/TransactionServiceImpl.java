package com.freecharge.demo1.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freecharge.demo1.DemoConstants;
import com.freecharge.demo1.TransactionTypeEnum;
import com.freecharge.demo1.dao.IBookRepositoryDao;
import com.freecharge.demo1.dao.IStudentRepositoryDao;
import com.freecharge.demo1.dao.ITransactionRepositoryDao;
import com.freecharge.demo1.exception.TransactionException;
import com.freecharge.demo1.model.BookEntity;
import com.freecharge.demo1.model.StudentEntity;
import com.freecharge.demo1.model.TransactionEntity;
import com.freecharge.demo1.request.BookIssueRequest;
import com.freecharge.demo1.request.BookSubmitRequest;
import com.freecharge.demo1.response.BookIssueResponse;
import com.freecharge.demo1.response.BookSubmitResponse;
import com.freecharge.demo1.response.transactionListResponse;
import com.freecharge.demo1.service.ITransactionService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionServiceImpl implements ITransactionService
{
	
	private ITransactionRepositoryDao transactionDao;
	
	private IStudentRepositoryDao studentDao;
	
	private IBookRepositoryDao bookDao;

	@Autowired
	public TransactionServiceImpl(ITransactionRepositoryDao transactionDao, IStudentRepositoryDao studentDao,
			IBookRepositoryDao bookDao) {
		this.transactionDao = transactionDao;
		this.studentDao = studentDao;
		this.bookDao = bookDao;
	}
	
	@Override
	@Transactional
	public BookIssueResponse issueBook(BookIssueRequest request) throws TransactionException
	{
		TransactionEntity transaction = new TransactionEntity();
		BookIssueResponse response = new BookIssueResponse();
		
		long bookId = request.getBookId();
		long studentId = request.getStudentId();
		
		BookEntity book = bookDao.getBookById(bookId);
		StudentEntity student = studentDao.getStudentById(studentId);
		
		if(student.getIssueCount() < DemoConstants.MAX_BOOK_COUNT && book.getBookCount() >= DemoConstants.MIN_BOOK_COUNT)
		{
			transaction.setBookID(bookId);
			transaction.setStudentID(studentId);
			
			book.setBookCount(book.getBookCount() - 1);
			student.setIssueCount(student.getIssueCount() + 1);
			
			studentDao.updateStudent(student);
			bookDao.updateBook(book);
			
			transaction.setBookCount(student.getIssueCount());
			transaction.setType("Issue");
			
			transaction.setType(TransactionTypeEnum.ISSUE.toString());
			long id = transactionDao.saveTransaction(transaction);
			
			log.info("transaction entity details:{}",transaction.toString());
			
			response.setResult("Transaction : ISSUED  Successful");
			response.setTransactionId(id);
			return response;
		}
		else
		{
			throw new TransactionException("Issue Operation cannnot be performed.");
		}
	}
	
	@Override
	@Transactional
	public BookSubmitResponse submitBook(BookSubmitRequest request) throws TransactionException
	{
		TransactionEntity transaction = new TransactionEntity();
		BookSubmitResponse response = new BookSubmitResponse();
		
		long bookId = request.getBookId();
		long studentId = request.getStudentId();
		
		BookEntity book = bookDao.getBookById(bookId);
		StudentEntity student = studentDao.getStudentById(studentId);
		
		if(student.getIssueCount()>=DemoConstants.MIN_BOOK_COUNT)
		{	
			transaction.setBookID(bookId);
			transaction.setStudentID(studentId);
			
			book.setBookCount(book.getBookCount() + 1);
			student.setIssueCount(student.getIssueCount() - 1);
			
			studentDao.updateStudent(student);
			bookDao.updateBook(book);
			
			transaction.setBookCount(student.getIssueCount());
			transaction.setType(TransactionTypeEnum.SUBMIT.toString());
			
			long id = transactionDao.saveTransaction(transaction);
			
			log.info("transaction entity details:{}",transaction.toString());
						
			response.setResult("Transaction : Submit Successful");
			response.setTransactionId(id);
			return response;
		}
		else 
		{
			throw new TransactionException("Submit Operation cannnot be performed.");
		}
	}
	
	@Override
	@Transactional
	public transactionListResponse getAllTransactions() 
	{
		transactionListResponse response = new transactionListResponse();
		
		response.setArr(transactionDao.getAllTransaction());
		
		return response;
	}
	
}
