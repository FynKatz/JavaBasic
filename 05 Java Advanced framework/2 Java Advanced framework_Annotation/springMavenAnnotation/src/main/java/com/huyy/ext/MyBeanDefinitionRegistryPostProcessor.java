package com.huyy.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

import com.huyy.beans.Car2;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor类postProcessBeanFactory()"
				+ "本次bean的数量"+beanFactory.getBeanDefinitionCount());		
	}

	//BeanDefinitionRegistry：Bean定义信息的保存中心。
	//以后BeanFactory就是按照BeanDefinitionRegistry里面保存的每一个bean定义信息创建bean实例。
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor类postProcessBeanDefinitionRegistry()"
				+ "本次bean的数量"+registry.getBeanDefinitionCount());			
		//手动添加注册对象
		RootBeanDefinition beanDefinition = new RootBeanDefinition(Car2.class);
		registry.registerBeanDefinition("newone", beanDefinition);//参数：bean名称，bean定义信息
	}

}
