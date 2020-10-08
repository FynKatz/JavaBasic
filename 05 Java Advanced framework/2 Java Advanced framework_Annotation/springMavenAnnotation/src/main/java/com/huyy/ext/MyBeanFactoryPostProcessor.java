package com.huyy.ext;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("执行了MyBeanFactoryPostProcessor的postProcessBeanFactory()");
		int count = beanFactory.getBeanDefinitionCount();
		String[] names = beanFactory.getBeanDefinitionNames();//beanFactory有几个bean
		System.out.println("当前beanfactory有"+count+"个bean");
		List<String> list = Arrays.asList(names);
		for (String name : list) {
			System.out.println(name);			
		}
	}

}
