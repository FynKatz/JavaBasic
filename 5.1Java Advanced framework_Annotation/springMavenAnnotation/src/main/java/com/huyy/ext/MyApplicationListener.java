package com.huyy.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent>{

	//当容器中发布此事件以后，方法触发
	@Override                     //监听 ApplicationEvent 及其下面的子事件
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("收到事件："+event);		
	}

}
