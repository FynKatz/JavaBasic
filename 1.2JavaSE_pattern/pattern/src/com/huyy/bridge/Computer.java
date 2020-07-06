package com.huyy.bridge; 

/**  
* @Description: 电脑类型的维度。
* @author yyhu
* @date 2020年3月22日  
* @version V1.0  
*/
//抽象类
abstract class Computer {
	protected Brand brand;

	//构造器
	public Computer(Brand brand) {
		super();
		this.brand = brand;
	}
	//调用Brand的sale()
	public void sale() {
		brand.sale();
	}
}
 
//实现类1
class DeskTopComputer extends Computer{
	//构造器
	public DeskTopComputer(Brand brand) {//可任意传入Brand对象
		super(brand);
	}

	//继承父类方法
	@Override
	public void sale() {
		super.sale();
		System.out.println("类型：台式机");
	}	
}

//实现类2
class PadComputer extends Computer{
	//构造器
	public PadComputer(Brand brand) {
		super(brand);
	}

	//继承父类方法
	@Override
	public void sale() {
		super.sale();
		System.out.println("类型：平板");
	}	
}