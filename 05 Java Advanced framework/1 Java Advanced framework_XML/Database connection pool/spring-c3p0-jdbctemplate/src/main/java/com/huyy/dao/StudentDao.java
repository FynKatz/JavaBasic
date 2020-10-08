package com.huyy.dao;

import java.util.List;

import com.huyy.pojo.Student;

public interface StudentDao {
 
	public int addStudent(Student student);
	
	public int updateStudent(Student student);
	
	public int deleteStudent(int id);
	
	public List<Student> findStudents();
}
 