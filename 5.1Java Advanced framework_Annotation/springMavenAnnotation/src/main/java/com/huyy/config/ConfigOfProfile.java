package com.huyy.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**  
 * @profile在多数据源上的使用
*/
@PropertySource("classpath:/jdbc.properties")//导入参数文件
@Configuration
public class ConfigOfProfile {
	
	@Value("${mysql.jdbc.test.username}")
	private String userNameTest;
	@Value("${mysql.jdbc.test.username}")
	private String userNameDev;
	@Value("${mysql.jdbc.test.username}")
	private String userNameProd;
	
	
	//开发数据源
	@Profile("test")
	@Bean
	public DataSource dataSourceTest(@Value("mysql.jdbc.password")String pwd) throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(userNameTest);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("${mysql.jdbc.test.url}");
		dataSource.setDriverClass("${mysql.jdbc.test.driverClassName}");
		
		return dataSource;
	}
	
	//测试数据源
	@Profile("dev")
	@Bean
	public DataSource dataSourceDev(@Value("mysql.jdbc.password")String pwd) throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(userNameDev);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("${mysql.jdbc.dev.url}");
		dataSource.setDriverClass("${mysql.jdbc.dev.driverClassName}");
		
		return dataSource;
	}
	
	//运营数据源
	@Profile("prod")
	@Bean
	public DataSource dataSourceProd(@Value("mysql.jdbc.password")String pwd) throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(userNameProd);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("${mysql.jdbc.prod.url}");
		dataSource.setDriverClass("${mysql.jdbc.prod.driverClassName}");
		
		return dataSource;
	}
}

//方式一
//@Configuration
//public class ConfigOfProfile {
//	
//	//开发数据源
//	@Bean
//	public DataSource dataSourceTest() throws Exception {
//		ComboPooledDataSource dataSource = new ComboPooledDataSource();
//		dataSource.setUser("root");
//		dataSource.setPassword("123456");
//		dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test");
//		dataSource.setDriverClass("com.mysql.jdbc.Driver");
//		
//		return dataSource;
//	}
//	
//	//测试数据源
//	@Bean
//	public DataSource dataSourceDev() throws Exception {
//		ComboPooledDataSource dataSource = new ComboPooledDataSource();
//		dataSource.setUser("root");
//		dataSource.setPassword("123456");
//		dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test02");
//		dataSource.setDriverClass("com.mysql.jdbc.Driver");
//		
//		return dataSource;
//	}
//	
//	//运营数据源
//	@Bean
//	public DataSource dataSourceProd() throws Exception {
//		ComboPooledDataSource dataSource = new ComboPooledDataSource();
//		dataSource.setUser("root");
//		dataSource.setPassword("123456");
//		dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test03");
//		dataSource.setDriverClass("com.mysql.jdbc.Driver");
//		
//		return dataSource;
//	}
//}
 