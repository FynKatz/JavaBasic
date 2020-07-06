package com.huyy.beans; 

public class People {
	private int id;
	private String name;
	private int age;
	
	public People() {
		System.out.println("执行无参构造器");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
 