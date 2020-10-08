package com.huyy.test;
 
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huyy.pojo.Student;
import com.huyy.service.StudentService;
 

 
 
public class Test01 {
 
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");;
		StudentService studentService=(StudentService)applicationContext.getBean("studentService");
		
		//测试插入
		int addNums=studentService.addStudent(new Student("王丹3", 1));
		if(addNums==1){
			System.out.println("插入成功");
		}
		
		//测试查找
		List<Student> list=studentService.findStudents();
		for (Student student : list) {
			System.out.println(student);
		}
		
		
	}

}