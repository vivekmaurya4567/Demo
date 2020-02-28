package com.freecharge.demo1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="transaction_table")
public class TransactionEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long transactionId;
	
	private long bookID;
	
	private long studentID;
	
	private int bookCount; 
	 
	private String type; 
}
