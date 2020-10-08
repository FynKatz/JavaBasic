package com.huyy.prototype;

import java.util.Date;

public class Sheep2 implements Cloneable{
	private String name;
	private Date birthday;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();  //直接调用object对象的clone()方法！
		
		
		//添加如下代码实现深复制(deep Clone)
		Sheep2 s = (Sheep2) obj;
		s.birthday = (Date) this.birthday.clone();  //把属性也进行克隆！
		
		return obj;
	}

	public Sheep2(String name, Date birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
