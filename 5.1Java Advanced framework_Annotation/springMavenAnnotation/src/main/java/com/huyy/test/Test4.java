package com.huyy.test;

import org.springframework.beans.factory.Aware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.huyy.config.ConfigOfAutowired;
import com.huyy.controller.BookController;

public class Test4 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigOfAutowired.class);
		
		BookController bookController = applicationContext.getBean(BookController.class);
		bookController.print();
		
		applicationContext.close();
		
	}
}
