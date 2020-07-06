package com.huyy.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判断是否linux系统
public class LinuxCondition implements Condition {

	/**
	 * ConditionContext：判断条件能使用的上下文（环境）
	 * AnnotatedTypeMetadata：注释信息
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

		//1、获取当前环境信息
		Environment environment = context.getEnvironment();
		//2.获取当前系统的名称
		String property = environment.getProperty("os.name");
		
		if(property.contains("linux")){
			return true;
		}
		
		return false;
	}

}
