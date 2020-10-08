package com.mzd.multipledatasources.mapper;

import org.springframework.stereotype.Repository;

import com.mzd.multipledatasources.bean.TeachersBean;
import com.mzd.multipledatasources.bean.TestBean;

@Repository
public interface TransactionMapping2 {

	void save(TestBean t);

}
