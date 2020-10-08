package com.huyy.adapter; 

/**  
* @Description: 适配器类
* @author yyhu
* @date 2020年3月21日  
* @version V1.0  
*/
public class Adapter extends Adaptee implements Target {
	//通过继承被适配者类，实现目标接口
	@Override
	public void request() {
		super.specificRequest();
	}

}
 