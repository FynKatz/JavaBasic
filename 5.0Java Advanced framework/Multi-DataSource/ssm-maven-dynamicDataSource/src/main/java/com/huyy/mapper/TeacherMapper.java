package com.huyy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huyy.beans.Teacher;

public interface TeacherMapper {
	
	public List<Teacher> getAllTeachers();
	public List<Teacher> getTeacherByName(@Param("name") String name);
}
