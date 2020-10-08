package com.huyy.ext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.huyy.beans.Car;

@ComponentScan("com.huyy.ext")
@Configuration
public class ExtConfig {
	
	@Bean
	public Car car(){
		return new Car();
	}
}
