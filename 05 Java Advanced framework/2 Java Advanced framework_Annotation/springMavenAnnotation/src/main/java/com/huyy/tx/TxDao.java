package com.huyy.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TxDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert(){
		String sql= "INSERT INTO teacher (id,name,sex,birthday,pro,depart) VALUES (?,?,?,?,?,?)";
		jdbcTemplate.update(sql, 1005,"张伟","男","1978-08-14 00:00:00","副教授","数学系");
	}
}
