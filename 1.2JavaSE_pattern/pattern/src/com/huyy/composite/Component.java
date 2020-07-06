package com.huyy.composite; 

/**  
* @Description: 抽象构件。
* @author yyhu
* @date 2020年3月22日  
* @version V1.0  
*/
//抽象构件
public interface Component {
	void operation();//基本方法
}

//树叶构件
interface Leaf extends Component {
}

//树枝（容器）构件
interface Composite extends Component {
	//树枝构件新增的对容器内元素的操作方法
	void add(Component c);
	void remove(Component c);
	Component getChild(int index);
}
 