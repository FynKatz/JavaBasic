package com.huyy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.huyy.dao.BookDao;

@Service
public class BookService {
	
	@Qualifier("bookDao")//指定
	@Autowired
	private BookDao bookDao;

}
 