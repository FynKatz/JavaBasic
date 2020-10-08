package com.huyy.advice;

import org.springframework.aop.ThrowsAdvice;

public class MyThrowAdvice02 implements ThrowsAdvice {

	public void afterThrowing(Exception ex) throws Throwable {
		System.out.println("执行异常通知 schema-based 方式");
	}
}
