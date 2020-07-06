package com.huyy.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huyy.pojo.Log;

public interface LogMapper {
	List<Log> selectAll();

	// 多参数（之前xml时，只能使用实体类对象来传参）
	List<Log> selectByAccInAccOut(@Param("accin") String accin, @Param("accout") String accout);
}
