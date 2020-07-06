package com.huyy.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.huyy.pojo.Student;

public interface StudentMapper {

	// 联合查询
	@Select("select s.id,s.name,age,tid,t.id `teacher.id`,t.name `teacher.name` "
			+ "from student s left join teacher t on s.tid=t.id")
	List<Student> selectAll();

	@Select("select * from student where tid=#{0}")
	List<Student> selectByTid(int tid);
}
