package com.huyy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.huyy.mapper") // @MapperScan 用户扫描MyBatis 的Mapper接口
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
