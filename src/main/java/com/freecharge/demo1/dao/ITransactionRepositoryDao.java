package com.freecharge.demo1.dao;

import java.util.List;

import com.freecharge.demo1.model.TransactionEntity;

public interface ITransactionRepositoryDao 
{

	List<TransactionEntity> getAllTransaction();

	long saveTransaction(TransactionEntity transaction);
	
}
