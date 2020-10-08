package com.huyy.test;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.huyy.config.ConfigOfProfile;

/**  
 * @profile测试
 * 
 *  使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test
*/

public class ProfileTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		                                                        //此处应用无参构造器，因为后面要修改参数
		
		applicationContext.getEnvironment().setActiveProfiles("dev","prod");//设置环境
		applicationContext.register(ConfigOfProfile.class);//注册主配置类
		applicationContext.refresh();//启动刷新容器
		
		//按照类型查找bean
		String[] nameForType = applicationContext.getBeanNamesForType(DataSource.class);
		for (String name : nameForType) {
			System.out.println(name);
		}
		
		
		
	}
}
 