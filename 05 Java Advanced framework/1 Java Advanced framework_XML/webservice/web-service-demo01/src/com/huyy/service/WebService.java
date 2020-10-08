package com.huyy.service;

import javax.jws.WebMethod;

@javax.jws.WebService
public interface WebService {
	@WebMethod
	String sayHello(String name);
}
