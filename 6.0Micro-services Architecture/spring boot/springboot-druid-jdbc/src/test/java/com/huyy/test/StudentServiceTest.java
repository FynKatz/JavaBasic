package com.huyy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.huyy.App;
import com.huyy.pojo.Student;
import com.huyy.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class) // 指定运行的主类
@SpringBootTest(classes=App.class) // 指定SpringBoot启动类,
public class StudentServiceTest {
	
	@Autowired
	private StudentService studentService;//注入最外层的service(接口，不是实现类的类名)
	
    @Test
    public void addStudent() {
    	studentService.addStudent(new Student("姚春",33));
    }
    
    @Test
    public void updateStudent(){
    	studentService.updateStudent(new Student(30,"赵敏",19));
    }
    
    @Test
    public void deleteStudent(){
    	studentService.deleteStudent(30);
    }
    
    //有返回值的方法不能直接测试？？
//    @Test
//    public List<Student> findStudents(){
//    	List<Student> list= studentService.findStudents();
//    	return list;
//    }
}
