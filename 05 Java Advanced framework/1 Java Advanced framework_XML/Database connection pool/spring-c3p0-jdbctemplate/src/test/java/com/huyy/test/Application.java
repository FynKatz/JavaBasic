package com.huyy.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.huyy.pojo.Student;
import com.huyy.service.StudentService;

/**用主方法来测试有返回值的方法*/
public class Application {
	
	public static void main(String[] args) throws Exception {

		// 1. 创建 Spring 的 IOC 容器: 从类路径加载xml配置文件
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 2.从 IOC 容器中获取 bean 的实例:以id的方式,注解时，用类名第一个字母小写的方式获取
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		StudentService studentService=ctx.getBean(StudentService.class);

		// 3.使用bean(测试有返回值的方法)
		List<Student> list= studentService.findStudents();
		for (Student student : list) {
			System.out.println(student);
		}
		
		// 4、关闭容器
		ctx.registerShutdownHook();

	}
}
