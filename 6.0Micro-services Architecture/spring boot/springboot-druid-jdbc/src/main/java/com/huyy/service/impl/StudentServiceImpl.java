package com.huyy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huyy.dao.StudentDao;
import com.huyy.pojo.Student;
import com.huyy.service.StudentService;

@Service  //不是说加了注解就好了，还要把前面的bean嵌套进来（dao）
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentDao;//注入dao(接口，不是实现类的类名)
	
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