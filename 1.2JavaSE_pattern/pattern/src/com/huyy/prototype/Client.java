package com.huyy.prototype;

import java.util.Date;

public class Client {
	public static void main(String[] args) throws CloneNotSupportedException {
		
		Date date = new Date(12312321331L);
		Sheep s1 = new Sheep("咩咩",date);
		System.out.println(s1);
		System.out.println(s1.getName()+s1.getBirthday());
		
		Sheep s2 = (Sheep) s1.clone();
		System.out.println(s2);
		System.out.println(s2.getName()+s2.getBirthday());
		
	}

}
