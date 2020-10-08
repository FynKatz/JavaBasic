package com.mzd.multipledatasources.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mzd.multipledatasources.bean.TestBean;
import com.mzd.multipledatasources.dao.TransactionDao1;
import com.mzd.multipledatasources.datasource.DataSourceType;
import com.mzd.multipledatasources.datasource.DataSourceType.DataBaseType;

@Service
public class TransactionService1 {
	@Autowired
	private TransactionDao1 ts1;

	@Transactional("mysqlTransactionManager")
	public void test01_saveTestBean() {
		DataSourceType.setDataBaseType(DataBaseType.MYSQL);
		
		TestBean tb1 = new TestBean();
		tb1.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		tb1.setScore(20);
		tb1.setClassid("1");
		tb1.setUserid("a");
		ts1.save(tb1);
		
		int i = 1/0;
		
		TestBean tb2 = new TestBean();
		tb2.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		tb2.setScore(20);
		tb2.setClassid("1");
		tb2.setUserid("a");
		ts1.save(tb2);
	}

}
