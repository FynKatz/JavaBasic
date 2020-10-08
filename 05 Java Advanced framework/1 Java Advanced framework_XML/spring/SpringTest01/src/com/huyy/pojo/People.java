package com.huyy.pojo;

public class People {
	private int id;
	private String name;

	// 无参构造器
	public People() {
		System.out.println("执行构造器");
	}

	// 有参构造器
	public People(int id, String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + "]";
	}

}
