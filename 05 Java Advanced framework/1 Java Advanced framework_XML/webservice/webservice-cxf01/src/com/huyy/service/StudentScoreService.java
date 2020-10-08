package com.huyy.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface StudentScoreService {
	@WebMethod
	public int getScore(String studentName);
}