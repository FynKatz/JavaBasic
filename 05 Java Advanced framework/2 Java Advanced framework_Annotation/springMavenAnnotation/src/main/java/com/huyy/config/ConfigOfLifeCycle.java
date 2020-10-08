package com.huyy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.huyy.beans.Car;

/**  
*  声明周期的配置类（相当于配置文件xml）
*/
@ComponentScan("com.huyy")
@Configuration
public class ConfigOfLifeCycle {
	
	@Bean(initMethod="init",destroyMethod="destroy")
	public Car car() {
		return new Car();
	}
}
 