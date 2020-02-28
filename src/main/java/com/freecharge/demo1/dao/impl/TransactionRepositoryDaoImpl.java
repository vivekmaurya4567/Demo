package com.freecharge.demo1.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.freecharge.demo1.dao.ITransactionRepositoryDao;
import com.freecharge.demo1.exception.BookNotFoundException;
import com.freecharge.demo1.exception.StudentInsertException;
import com.freecharge.demo1.exception.TransactionException;
import com.freecharge.demo1.model.TransactionEntity;
import com.freecharge.demo1.repository.TransactionRepository;

@Component
public class TransactionRepositoryDaoImpl implements ITransactionRepositoryDao
{
	private TransactionRepository transactionRepo;
	
	@Autowired
	public TransactionRepositoryDaoImpl(TransactionRepository transactionRepo) {
		super();
		this.transactionRepo = transactionRepo;
	}

	@Override
	@Transactional
	public List<TransactionEntity> getAllTransaction() 
	{
		try {
			List<TransactionEntity> arr = transactionRepo.findAll();
				if(arr != null)
				return arr;
				else throw new TransactionException("transaction records not found");
			}
		catch(Exception ex)
			{
				throw new BookNotFoundException("RuntimeException during getAllTransactions operation.");
			}
	}

	@Override
	@Transactional
	public long saveTransaction(TransactionEntity transaction) 
	{
		try {
				TransactionEntity transactionEntity=transactionRepo.save(transaction);
				return transactionEntity.getTransactionId();
			}
			catch(Exception ex)
			{
				throw new StudentInsertException("RuntimeException during Issue operation.");
			}
	}
	
}
