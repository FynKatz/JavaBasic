package com.huyy.service;

import java.util.List;

import com.huyy.beans.Teacher;

public interface TeacherService {
	List<Teacher> getAllTeachers();
	List<Teacher> getTeacherByName(String name);
}
