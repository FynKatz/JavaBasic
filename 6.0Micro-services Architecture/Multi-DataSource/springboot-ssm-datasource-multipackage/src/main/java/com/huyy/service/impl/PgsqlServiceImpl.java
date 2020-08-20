package com.huyy.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huyy.beans.TeachersBean;
import com.huyy.mapper.pgsql.PgsqlMapper;
import com.huyy.service.PgsqlService;

@Service
public class PgsqlServiceImpl implements PgsqlService{
	
	@Autowired
	private PgsqlMapper pgsqlMapper;

	@Override
	@Transactional("pgsqlTransactionManager")
	public void saveTeacher() {
		
		TeachersBean tb1 = new TeachersBean();
		tb1.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		tb1.setTeachername("王老师");
		tb1.setClassid("1");
		pgsqlMapper.save(tb1);
		
		
		TeachersBean tb2 = new TeachersBean();
		tb2.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		tb2.setTeachername("李老师");
		tb2.setClassid("2");
		pgsqlMapper.save(tb2);
	}

}
