package com.huyy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.huyy.mapper")
public class DataSourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataSourcesApplication.class, args);
	}
}
