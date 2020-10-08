package com.huyy.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.huyy.pojo.Student;

public class Test {
	public static void main(String[] args) throws IOException {

		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();

		List<Student> list = session.selectList("com.huyy.mybatis.mapper.StudentMapper.selectAll2");
		for (Student student : list) {
			System.out.println(student);
		}

		session.close();
		System.out.println("程序结束");
	}
}
