package com.huyy.service;


import java.util.List;

import com.huyy.pojo.Student;
 
public interface StudentService {
 
	public int addStudent(Student student);
	
	public int updateStudent(Student student);
	
	public int deleteStudent(int id);
	
	public List<Student> findStudents();
}