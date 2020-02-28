package com.freecharge.demo1.service;

import com.freecharge.demo1.exception.TransactionException;
import com.freecharge.demo1.request.BookIssueRequest;
import com.freecharge.demo1.request.BookSubmitRequest;
import com.freecharge.demo1.response.BookIssueResponse;
import com.freecharge.demo1.response.BookSubmitResponse;
import com.freecharge.demo1.response.transactionListResponse;

public interface ITransactionService {

	transactionListResponse getAllTransactions();

	BookIssueResponse issueBook(BookIssueRequest request) throws TransactionException;

	BookSubmitResponse submitBook(BookSubmitRequest request) throws TransactionException;

}
