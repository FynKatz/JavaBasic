package com.huyy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.huyy.beans.Color;
import com.huyy.beans.ColorFactoryBean;
import com.huyy.beans.People;
import com.huyy.condition.LinuxCondition;
import com.huyy.condition.MyImportSelector;
import com.huyy.condition.WindowsCondition;

/** 配置类相当于之前的配置文件applicationContext.xml
 * @author Fanel
 *
 */
@Configuration
@ComponentScan(value="com.huyy")
//@Import(Color.class)
@Import({MyImportSelector.class})
public class SpringConfig {
	
	//给容器注册一个bean
//	@Bean("people") //或者注解上为bean定义名称
//	@Scope("singleton")
//	@Lazy
	@Conditional({WindowsCondition.class})
	@Bean  //@Bean("people")好像会报错，反正下面的方法名就是bean的名称
	public People people() {
		//这里的方法名相当于之前的id，这里的返回值类型就是之前的class
//		System.out.println("bean被加载到IOC容器");
		return new People(1,"kiki",18);
	}
	
	@Conditional({LinuxCondition.class})
	@Bean
	public People people01() {
		//这里的方法名相当于之前的id，这里的返回值类型就是之前的class
//		System.out.println("bean被加载到IOC容器");
		return new People(2,"joe",19);
	}
	
	@Bean
	public ColorFactoryBean colorFactoryBean() {
		return new ColorFactoryBean();
	}
}
 