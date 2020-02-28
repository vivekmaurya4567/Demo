package com.freecharge.demo1.dao;

import java.util.List;

import com.freecharge.demo1.model.StudentEntity;

public interface IStudentRepositoryDao
{
	public long insertStudent(StudentEntity student);
	
	public StudentEntity getStudentById(long id);

	public List<StudentEntity> getAllStudents();

	public long deleteStudent(StudentEntity student);

	public long updateStudent(StudentEntity student);

	
}
