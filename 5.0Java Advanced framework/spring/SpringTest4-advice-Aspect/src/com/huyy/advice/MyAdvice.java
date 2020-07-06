package com.huyy.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
	@Before("com.huyy.test.Demo.demo1()")
	public void mybefore() {
		System.out.println("前置");
	}

	@After("com.huyy.test.Demo.demo1()")
	public void myafter() {
		System.out.println("后置通知");
	}
}
