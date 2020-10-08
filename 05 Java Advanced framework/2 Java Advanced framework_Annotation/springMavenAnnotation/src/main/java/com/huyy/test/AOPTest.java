package com.huyy.test;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.huyy.aop.MathCalculator;
import com.huyy.config.ConfigOfAop;
import com.huyy.config.ConfigOfProfile;

/**  
 * AOP测试
 *
*/

public class AOPTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigOfAop.class);
		                                                       
		MathCalculator mathCalculator = (MathCalculator) applicationContext.getBean("mathCalculator");
		mathCalculator.div(5, 2);
		
		
		applicationContext.close();
	}
}
 