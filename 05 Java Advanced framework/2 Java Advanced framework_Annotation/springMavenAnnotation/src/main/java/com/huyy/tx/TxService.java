package com.huyy.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TxService {
	
	@Autowired
	TxDao txDao;
	
	@Transactional(rollbackFor=Exception.class) 
	public void insertTeacher(){
		txDao.insert();
		int i = 1/0;//测试事务回滚
		System.out.println("插入成功");
	}
}
