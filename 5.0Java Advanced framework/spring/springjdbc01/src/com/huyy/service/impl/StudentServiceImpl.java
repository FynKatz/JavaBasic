package com.huyy.service.impl;


import java.util.List;

import com.huyy.dao.StudentDao;
import com.huyy.pojo.Student;
import com.huyy.service.StudentService;
 
public class StudentServiceImpl implements StudentService{
 
	private StudentDao studentDao;
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
 
	@Override
	public int addStudent(Student student) {
		return studentDao.addStudent(student);
	}
 
	@Override
	public int updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}
 
	@Override
	public int deleteStudent(int id) {
		return studentDao.deleteStudent(id);
	}
 
	@Override
	public List<Student> findStudents() {
		return studentDao.findStudents();
	}
}