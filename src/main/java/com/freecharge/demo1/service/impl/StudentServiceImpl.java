package com.freecharge.demo1.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freecharge.demo1.dao.IStudentRepositoryDao;
import com.freecharge.demo1.model.StudentEntity;
import com.freecharge.demo1.request.StudentDeleteRequest;
import com.freecharge.demo1.request.StudentRequest;
import com.freecharge.demo1.request.StudentUpdateRequest;
import com.freecharge.demo1.response.StudentInsertResponse;
import com.freecharge.demo1.response.StudentListResponse;
import com.freecharge.demo1.response.StudentResponse;
import com.freecharge.demo1.service.IStudentService;

//import jdk.internal.org.jline.utils.Log;
//import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class StudentServiceImpl implements IStudentService 
{
	private IStudentRepositoryDao studentDao; 
	
	@Autowired
	public StudentServiceImpl(IStudentRepositoryDao studentDao)
	{
		this.studentDao=studentDao;
	}
	
	@Override
	@Transactional
	public StudentInsertResponse insertStudent(StudentRequest student)
	{		
		StudentEntity studentEntity=new StudentEntity();
		BeanUtils.copyProperties(student, studentEntity);
		
		long id = studentDao.insertStudent(studentEntity);
		
		log.info("student entity details:{}",studentEntity.toString());
		
		StudentInsertResponse response = new StudentInsertResponse();
		response.setResult("Student added sucessfully at id "+id+" .");
		return response;
	}

	@Override
	@Transactional
	public StudentResponse getStudentById(long id)
	{
		StudentEntity studentEntity = studentDao.getStudentById(id);
		
		log.info("student entity details:{}",studentEntity.toString());
		
		StudentResponse response = new StudentResponse();
			response.setResult("Student record found:");
			response.setId(id);
			response.setName(studentEntity.getName());
		return response;
	}

	@Override
	@Transactional
	public StudentListResponse getAllStudents() 
	{
		StudentListResponse response = new StudentListResponse();
		List<StudentEntity> arr = studentDao.getAllStudents();
		response.setArr(arr);
		return response;
	}

	@Override
	@Transactional
	public StudentResponse updateStudent(StudentUpdateRequest newDetails) {
		StudentResponse response = new StudentResponse();
		
		long id = newDetails.getId();
		StudentEntity student = studentDao.getStudentById(id);
		student.setName(newDetails.getName());
		student.setDegree(newDetails.getDegree());
		student.setDob(newDetails.getDob());
		
		id = studentDao.updateStudent(student);
		
		log.info("student entity details:{}",student.toString());
		
		response.setResult("update Succesfull");
		response.setName(student.getName());
		response.setId(id);
		return response;
	}

	@Override
	@Transactional
	public StudentResponse deleteStudent(StudentDeleteRequest newDetails) {
		StudentResponse response = new StudentResponse();
		
		long id = newDetails.getId();
		StudentEntity student = studentDao.getStudentById(id);
		
		id = studentDao.deleteStudent(student);
		
		log.info("student entity details:{}",student.toString());
		
		response.setResult("Delete Successful");
		response.setId(student.getStudentId());
		response.setName(student.getName());
		return response;
	}	
}