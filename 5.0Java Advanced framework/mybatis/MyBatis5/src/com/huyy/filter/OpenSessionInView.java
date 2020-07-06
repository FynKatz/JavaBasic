package com.huyy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.ibatis.session.SqlSession;

import com.huyy.util.MybatisUtil;

/*最开始是由Spring框架提出的.整合Hibernate框架是使用的是OpenSessionInView*/
@WebFilter("/*")
public class OpenSessionInView implements Filter {
	@Override
	public void init(FilterConfig filterconfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterchain)
			throws IOException, ServletException {
		// 利用Mybatis的工具类来创建session
		SqlSession session = MybatisUtil.getSession();
		try {
			filterchain.doFilter(servletrequest, servletresponse);// 手动放行
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			MybatisUtil.closeSession();
		}

	}

	@Override
	public void destroy() {

	}
}
