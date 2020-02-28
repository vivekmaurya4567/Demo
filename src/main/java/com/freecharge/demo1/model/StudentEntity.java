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

import java.util.Date;
//import java.util.Calendar;

@Entity	
@Table(name ="Student_Details")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studentId;
	
	private String name;
	
	private String degree;
	
	private Date dob;
	
	private int issueCount;	
}
