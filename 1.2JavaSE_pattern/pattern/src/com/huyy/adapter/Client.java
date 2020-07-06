package com.huyy.adapter; 

/**  
* @Description: 客户端，调用目标接口
* @author yyhu
* @date 2020年3月21日  
* @version V1.0  
*/
public class Client {

	public static void main(String[] args) {
//		Target target = new Adapter();
//		target.request();
//		//实际调用适配器的request()，而该方法又继承自被适配者的方法specificRequest()	
		Adaptee adaptee = new Adaptee();
		Target target = new Adapter2(adaptee);
		target.request();
		
	}
}
 