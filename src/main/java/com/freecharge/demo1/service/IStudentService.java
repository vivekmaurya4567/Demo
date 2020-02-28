package com.freecharge.demo1.service;

import com.freecharge.demo1.request.StudentDeleteRequest;
import com.freecharge.demo1.request.StudentRequest;
import com.freecharge.demo1.request.StudentUpdateRequest;
import com.freecharge.demo1.response.StudentInsertResponse;
import com.freecharge.demo1.response.StudentListResponse;
import com.freecharge.demo1.response.StudentResponse;

public interface IStudentService 
{

	public StudentInsertResponse insertStudent(StudentRequest studentRequest);

	public StudentResponse getStudentById(long id);

	public StudentListResponse getAllStudents();

	public StudentResponse updateStudent(StudentUpdateRequest newDetails);
	
	public StudentResponse deleteStudent(StudentDeleteRequest newDetails);
}
