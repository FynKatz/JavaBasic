package com.huyy.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import com.huyy.service.StudentScoreService;

//必须指定对外发布服务的接口
@WebService(endpointInterface="com.huyy.service.StudentScoreService")
public class StudentScoreServiceImpl implements StudentScoreService {
	
	private static Map<String,Integer> map = new HashMap<>();
	static {
		map.put("小赖", 100);
		map.put("小王", 90);
		map.put("小李", 80);
		map.put("小张", 70);
	}
	
	@Override
	public int getScore(String studentName) {
		return map.get(studentName);
	}
}
