package com.huyy.mapper.pgsql;

import org.springframework.stereotype.Repository;

import com.huyy.beans.TeachersBean;

@Repository
public interface PgsqlMapper {

	void save(TeachersBean t);

}
