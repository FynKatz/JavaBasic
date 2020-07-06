package com.huyy.singleton;

public class Client01 {
	public static void main(String[] args) {
		Singleton05 s1 = Singleton05.INSTANCE;
		Singleton05 s2 = Singleton05.INSTANCE;
		
		System.out.println(s1==s2);
		
	}
}
