package com.huyy.composite; 

/**  
* @Description: 
* @author yyhu
* @date 2020年3月22日  
* @version V1.0  
*/
public class Client {
	public static void main(String[] args) {
		
		AbstractFile f2,f3,f4,f5;//定义文件（树叶）
		Folder folder = new Folder("文件夹1");//定义文件夹（树枝/容器）
		
		f2 = new ImageFile("图像1.jpg");
		f3 = new ImageFile("Hello.png");
		folder.add(f2);
		folder.add(f3);//加入容器。
		//因为Folder类中，有两种String 和List，这里存储的是String。
		
		Folder childFolder = new Folder("子文件夹");
		f4 = new ImageFile("子文件夹下---新图1.jpg");
		f5 = new ImageFile("子文件夹下---新图2.jpg");
		childFolder.add(f4);
		childFolder.add(f5);
		folder.add(childFolder);
		//因为Folder类中，有两种String 和List，这里存储的是L。
		
		//杀毒（调用）
		f2.killVirus();//单独文件杀毒
		
		System.out.println();
		
		folder.killVirus();//文件夹杀毒
		
		
	}
}
 