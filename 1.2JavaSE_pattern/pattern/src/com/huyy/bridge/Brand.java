package com.huyy.bridge; 

/**  
* @Description: 品牌维度。
* @author yyhu
* @date 2020年3月22日  
* @version V1.0  
*/

//接口
public interface Brand {
	void sale();
}
 
//实现类1
class DellBrand implements Brand {

	@Override
	public void sale() {
		System.out.println("销售：戴尔电脑");
	}

}

//实现类2
class HpBrand implements Brand {

	@Override
	public void sale() {
		System.out.println("销售：惠普电脑");
	}

}