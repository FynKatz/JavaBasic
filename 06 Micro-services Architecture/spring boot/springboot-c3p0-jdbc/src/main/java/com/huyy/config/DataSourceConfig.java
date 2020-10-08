package com.huyy.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@SpringBootConfiguration
public class DataSourceConfig {

	@Bean(name = "dataSource")
	@Qualifier(value = "dataSource")
	@Primary // primary将当前数据库连接池作为默认数据库连接池
	@ConfigurationProperties(prefix = "c3p0") // 在application.properties文件中增加前缀c3p0
	public DataSource dataSource() {
		return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
	}

	//可不用手动将datasource注入JdbcTemplate，springboot会自动操作
}
