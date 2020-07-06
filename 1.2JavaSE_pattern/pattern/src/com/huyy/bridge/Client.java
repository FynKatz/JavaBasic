package com.huyy.bridge; 

/**  
* @Description: 
* @author yyhu
* @date 2020年3月22日  
* @version V1.0  
*/
public class Client {
	public static void main(String[] args) {
		//销售戴尔平板电脑
		Computer dellPadComputer = new PadComputer(new DellBrand());//通过组合方式
		dellPadComputer.sale();
		
		System.out.println("");
		
		//销售惠普台式机电脑
		Computer hpDeskTopComputer = new DeskTopComputer(new HpBrand());
		hpDeskTopComputer.sale();
	}

}
 