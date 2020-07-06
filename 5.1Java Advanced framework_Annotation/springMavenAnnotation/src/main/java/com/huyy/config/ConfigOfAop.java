package com.huyy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.huyy.aop.LogAspects;
import com.huyy.aop.MathCalculator;

/**
 * Aop测试
 * @author Fanel
 *
 */
@EnableAspectJAutoProxy
@Configuration
public class ConfigOfAop {
	
	//注册bean
	@Bean
	public MathCalculator mathCalculator() {
		return new MathCalculator();
	}
	
	@Bean
	public LogAspects logAspects() {
		return new LogAspects();
	}
}
 