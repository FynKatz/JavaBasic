package com.huyy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.huyy.beans.Color;

/**  
*  声明周期的配置类（相当于配置文件xml）
*/

@ComponentScan("com.huyy.beans")
//@PropertySource(value={"classpath:/color.properties"},ignoreResourceNotFound=true)
//@PropertySource(value={"classpath:color.properties"})
@Configuration
public class ConfigOfPropertyValue {
	
//	@Bean
//	public Color color() {
//		return new Color();
//	}
}
 