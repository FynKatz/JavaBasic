package com.huyy.test;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Demo {

	@Pointcut("execution(* com.huyy.test.Demo.demo1())")
	public void demo1() {
		System.out.println("demo1");
	}
}
