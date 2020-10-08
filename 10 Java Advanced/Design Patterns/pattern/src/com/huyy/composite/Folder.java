package com.huyy.composite;

import java.util.ArrayList;
import java.util.List;

/**  
* @Description: 树枝（容器）构件---文件夹。
* @author yyhu
* @date 2020年3月22日  
* @version V1.0  
*/
public class Folder implements AbstractFile {
	
	//文件名
	private String name;
	//定义容器，用来存放本容器构建下的子节点
	private List<AbstractFile> list = new ArrayList<AbstractFile>();
	
	//构造器
	public Folder(String name) {
		super();
		this.name = name;
	}
	
	public void add(AbstractFile file){
		list.add(file);
	}
	public void remove(AbstractFile file){
		list.remove(file);
	}
	public AbstractFile getChild(int index){
		return list.get(index);
	}

	//递归查杀（文件夹下有子文件夹会递归）。
	@Override
	public void killVirus() {
		System.out.println("---文件夹："+name+",进行查杀");
		
		for (AbstractFile file : list) {
			file.killVirus();
		}
		
	}


}
 