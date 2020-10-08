package com.huyy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.huyy.filter.SecondFilter;
import com.huyy.servlet.SecondServ;

@SpringBootApplication
public class App2 {
	public static void main(String[] args) {
		SpringApplication.run(App2.class, args);
	}
	
	/**
	* 注册Servlet
	* @return
	*/
	@Bean
	public ServletRegistrationBean getServletRegistrationBean(){
		ServletRegistrationBean bean=new ServletRegistrationBean(new SecondServ());
		bean.addUrlMappings("/serv02");
		return bean;
	}
	
	/**
	* 注册Filter
	*/
	public FilterRegistrationBean getFilterRegistrationBean(){
		FilterRegistrationBean bean=new FilterRegistrationBean(new SecondFilter());
		bean.addUrlPatterns("/serv02");
		return bean;
	}
}