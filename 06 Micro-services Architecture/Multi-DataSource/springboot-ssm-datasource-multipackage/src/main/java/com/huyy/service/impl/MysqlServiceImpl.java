package com.huyy.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huyy.beans.TestBean;
import com.huyy.mapper.mysql.MysqlMapper;
import com.huyy.service.MysqlService;

@Service
public class MysqlServiceImpl implements MysqlService{
	
	@Autowired
	private MysqlMapper mysqlMapper;

	@Override
	@Transactional("mysqlTransactionManager")
	public void savetestBean() {
		TestBean tb1 = new TestBean();
		tb1.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		tb1.setScore(70);
		tb1.setClassid("1");
		tb1.setUserid("a");
		mysqlMapper.save(tb1);
		
//		int i = 1/0;
		
		TestBean tb2 = new TestBean();
		tb2.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		tb2.setScore(71);
		tb2.setClassid("2");
		tb2.setUserid("b");
		mysqlMapper.save(tb2);
		
		
	}
}
