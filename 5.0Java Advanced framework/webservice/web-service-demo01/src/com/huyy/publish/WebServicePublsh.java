package com.huyy.publish;

import javax.xml.ws.Endpoint;

import com.huyy.service.impl.WebServiceImpl;

public class WebServicePublsh {
	public static void main(String[] args) {
		//定义WebService的发布地址，这个地址就是提供给外界访问WebService的URL地址
		String address="http://localhost:8089/ws_server/webservice";
		//发布WebService
		Endpoint.publish(address, new WebServiceImpl());
		System.out.println("发布成功！");
	}
}