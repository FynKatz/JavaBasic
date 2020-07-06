package com.huyy.composite; 

/**  
* @Description: 杀毒软件的树叶构件--图片查杀。
* @author yyhu
* @date 2020年3月22日  
* @version V1.0  
*/
public class ImageFile implements AbstractFile {
	
	private String name;//文件名
	//构造器
	public ImageFile(String name) {
		super();
		this.name = name;
	}

	@Override
	public void killVirus() {
		System.out.println("---图像文件：" + name + ",进行查杀！");
	}

}
 