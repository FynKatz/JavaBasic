package com.huyy.tx;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@EnableTransactionManagement
@ComponentScan("com.huyy.tx")
@Configuration
public class TxConfig {
	
	//数据源
	@Bean
	public DataSource dataSource() throws Exception {
		
		ComboPooledDataSource dataSource = new ComboPooledDataSource();//实例化c3p0的数据源对象
		
		dataSource.setUser("root");//设置属性值
		dataSource.setPassword("123456");
		dataSource.setJdbcUrl("jdbc:mysql://47.97.125.255:3306/test"
				+ "?useSSL=false&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		
		return dataSource;
	}
	
	//jdbc模板类
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) throws Exception{ //直接注入上面的DataSource的实例对象
		//备注：Spring对@Configuration类会特殊处理；给容器中加组件的方法，多次调用都只是从容器中找组件（只创建单例对象Bean）
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}
	
	//注册事务管理器在容器中
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) throws Exception{
		return new DataSourceTransactionManager(dataSource);
	}
}
