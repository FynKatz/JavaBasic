package com.huyy.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.huyy.mybatis.mapper.TeacherMapper;
import com.huyy.pojo.Teacher;

public class Test {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();

		TeacherMapper tm = session.getMapper(TeacherMapper.class);
		List<Teacher> list = tm.selectTeacher();
		for (Teacher teacher : list) {
			System.out.println(teacher);
		}
		session.close();
		System.out.println("程序结束");
	}
}
