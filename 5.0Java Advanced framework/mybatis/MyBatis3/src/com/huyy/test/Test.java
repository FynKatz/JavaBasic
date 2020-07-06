package com.huyy.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.huyy.mybatis.mapper.LogMapper;
import com.huyy.pojo.Log;

public class Test {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();

		// 接口绑定创建类
		LogMapper logMapper = session.getMapper(LogMapper.class);
		List<Log> list = logMapper.selectAll();
		for (Log log : list) {
			System.out.println(log);
		}
		// 上面语句相当于下面语句
		List<Log> list2 = session.selectList("com.huyy.mybatis.mapper.LogMapper.selectAll");

		LogMapper logMapper2 = session.getMapper(LogMapper.class);
		List<Log> list3 = logMapper2.selectByAccInAccOut("50", "3");
		for (Log log : list3) {
			System.out.println(log);
		}

		session.close();
		System.out.println("程序结束");
	}
}
