package com.huyy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.huyy.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	public void print() {
		System.out.println(bookService);
	}
}
 