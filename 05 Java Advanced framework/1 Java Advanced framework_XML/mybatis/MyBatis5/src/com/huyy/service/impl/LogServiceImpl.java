package com.huyy.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.huyy.mybatis.mapper.LogMapper;
import com.huyy.pojo.Log;
import com.huyy.service.LogService;
import com.huyy.util.MybatisUtil;

public class LogServiceImpl implements LogService {

	@Override
	public int insertLog(Log log) {
		SqlSession session = MybatisUtil.getSession();
		LogMapper mapper = session.getMapper(LogMapper.class);
		return mapper.insertLog(log);

	}

}
