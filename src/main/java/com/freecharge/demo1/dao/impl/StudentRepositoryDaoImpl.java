package com.freecharge.demo1.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import com.freecharge.demo1.response.StudentResponse;
import com.freecharge.demo1.dao.IStudentRepositoryDao;
import com.freecharge.demo1.exception.StudentInsertException;
import com.freecharge.demo1.exception.StudentNotFoundException;
import com.freecharge.demo1.model.StudentEntity;
import com.freecharge.demo1.repository.StudentRepository;
//import com.freecharge.demo1.request.StudentRequest;

@Component
public class StudentRepositoryDaoImpl implements IStudentRepositoryDao
{
	private StudentRepository studentRepo;
	
	@Autowired
	public StudentRepositoryDaoImpl(StudentRepository studentRepo)
	{
		this.studentRepo=studentRepo;
	}
	
	@Override
	@Transactional
	public long insertStudent(StudentEntity student)
	{
		
		try {
				StudentEntity studentEntity=studentRepo.save(student);
	
				return studentEntity.getStudentId();
		}
		catch(StudentInsertException ex)
		{
			throw new StudentInsertException("Student details are wrong.");
		}
		catch(Exception ex)
		{
			throw new StudentInsertException("RuntimeException during insert operation.");
		}
	}

	@Override
	@Transactional
	public StudentEntity getStudentById(long id)
	{
		try {
				Optional<StudentEntity>	studentOp=studentRepo.findById(id);
				if(studentOp.isPresent())
				{
					return studentOp.get();
				}
				else
				{
					throw new StudentNotFoundException("Student record not found with id = "+ id);
				}
		}
		catch(Exception ex)
		{
			throw new StudentNotFoundException("RuntimeException during getStudentById operation.");
		}
	}

	@Override
	@Transactional
	public List<StudentEntity> getAllStudents()
	{
		try 
		{
			if(studentRepo.findAll()!=null)
			return studentRepo.findAll();
			else throw new StudentNotFoundException("No Records found.");
		}
		catch(Exception ex)
		{
			throw new StudentNotFoundException("RuntimeException during getAllStudents operation.");
		}
		
	}

	@Override
	@Transactional
	public long deleteStudent(StudentEntity student) {
		try
		{
			studentRepo.delete(student);
			return student.getStudentId();
		}
		catch(Exception ex)
		{
			throw new StudentNotFoundException("RuntimeException during deleteStudent operation.");
		}
	}

	@Override
	@Transactional
	public long updateStudent(StudentEntity student) 
	{
		try {
			StudentEntity studentEntity=studentRepo.save(student);
			return studentEntity.getStudentId();
			}
			catch(StudentInsertException ex)
			{
				throw new StudentInsertException("Student details are wrong.");
			}
			catch(Exception ex)
			{
				throw new StudentInsertException("RuntimeException during update operation.");
			}
	}

	
}
