package com.huyy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huyy.beans.Teacher;
import com.huyy.mapper.TeacherMapper;
import com.huyy.service.TeacherService;

@Service //默认@Service的bean名称是teacherService
public class TeacherServiceImpl implements TeacherService{

	@Resource
	TeacherMapper teacherMapper;
	
	@Override
	public List<Teacher> getAllTeachers() {
		return teacherMapper.getAllTeachers();
	}

	@Override
	public List<Teacher> getTeacherByName(String name) {
		return teacherMapper.getTeacherByName(name);
	}

}
