package com.huyy.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.huyy.pojo.User;

public class Test {
	public static void main(String[] args) throws IOException {

		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		// 使用工厂设计模式
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		// 生产SqlSession
		SqlSession session = factory.openSession();
		// 执行SQL--查询整个列表
		List<User> list = session.selectList("com.huyy.mapper.UserMapper.selAll");
		for (User user : list) {
			System.out.println(user.toString());
		}
		// 执行SQL--查询单条记录
		User user = session.selectOne("com.huyy.mapper.UserMapper.selectById", 1);
		System.out.println(user);

		// 插入
		// User user2 = new User(3, "kop");
		// int value = session.insert("com.huyy.mapper.UserMapper.insertUser",
		// user2);
		// System.out.println(value > 0 ? "true" : "false");
		// session.commit();

		// 修改
		// User user3 = new User();
		// user3.setId(3);
		// user3.setName("mimi");
		// session.update("com.huyy.mapper.UserMapper.updateUserBYId", user3);
		// session.commit();

		// 删除
		int value2 = session.delete("com.huyy.mapper.UserMapper.deleteUserById", 3);
		session.commit();
		System.out.println(value2 > 0 ? "true" : "false");

		session.close();
	}
}
