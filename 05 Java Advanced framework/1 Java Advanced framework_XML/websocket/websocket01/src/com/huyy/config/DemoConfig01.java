package com.huyy.config;

import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

public class DemoConfig01 implements ServerApplicationConfig{

	//1.ע�ⷽʽʵ�֣�����Ҫ���ã��Զ���Tomcat���ã�
	@Override
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scaned) {
		System.out.println("websocket����"+scaned);
		
		return scaned;//һ��Ҫ����
	}

	//2.�ӿ�ʵ��
	@Override
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
