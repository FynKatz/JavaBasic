package com.huyy.mall;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderMainApplication {
	
	public static void main(String[] args) throws IOException {
	    
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("provider.xml");
		applicationContext.start();
		
		System.in.read();
	}

}
