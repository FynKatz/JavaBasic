package com.wiscom.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wiscom.bean.TestBean;
import com.wiscom.service.TestService;
import com.wiscom.util.JdbcUtil;

/**
* @author gavin
* @version 创建日期:2019年9月5日
*/
@Service
public class TestServiceImpl implements TestService {

	/* (non-Javadoc)
	 * @see com.wiscom.service.TestService#httpTest()
	 */
	@Override
	public List<TestBean> httpTest() {
		List<TestBean> list = new ArrayList<TestBean>();
		TestBean tb;
		String sql = "select * from dv_in_out_store_house";
		ResultSet rs = JdbcUtil.select(sql);
		if(rs != null)
		{
			try {
				while(rs.next())
				{
					tb = new TestBean();
					tb.setName(rs.getString("store_house_name"));
					list.add(tb);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

}
