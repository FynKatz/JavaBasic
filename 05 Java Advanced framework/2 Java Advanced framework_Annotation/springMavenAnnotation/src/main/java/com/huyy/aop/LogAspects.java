package com.huyy.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


/**
 *  日志切面类
 * @author Fanel
 *
 */
@Aspect
public class LogAspects {
	
	@Pointcut("execution(public int com.huyy.aop.MathCalculator.*(..))")
	public void pointCut(){
		
	}
	
	@Before("pointCut()")//针对MathCalculator类下所有的方法
	public void logStart(){
		System.out.println("除法运算开始前通知");
	}
	
	@After("pointCut()")
	public void logEnd(){
		System.out.println("除法运算开始后通知");
	}
	
	@AfterReturning("pointCut()")
	public void logReturn(){
		System.out.println("除法运行正常返回值");
	}

	@AfterThrowing("pointCut()")
	public void logException(){
		System.out.println("除法运行异常");
	}

}
