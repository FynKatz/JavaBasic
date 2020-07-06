package com.huyy.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.huyy.tx.TxConfig;
import com.huyy.tx.TxService;

public class TxTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext 
		                                   = new AnnotationConfigApplicationContext(TxConfig.class);

		TxService txService = applicationContext.getBean(TxService.class);
		txService.insertTeacher();

		applicationContext.close();
	}
}
