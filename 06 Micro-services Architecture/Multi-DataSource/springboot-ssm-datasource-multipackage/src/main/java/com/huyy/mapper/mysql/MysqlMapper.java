package com.huyy.mapper.mysql;

import org.springframework.stereotype.Repository;

import com.huyy.beans.TestBean;

@Repository
public interface MysqlMapper {

	void save(TestBean t);

}
