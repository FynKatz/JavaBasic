package com.huyy.container;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 实现一个容器提供两个方法 add和size，写两个线程，线程1添加10个元素到容器中，
 * 线程2进行监控，当容器内元素达到5时，线程2给出提示并结束。
 */
public class MyContainer01 {
    //这里一定要加volatile，否则线程2无法监测到堆内存中 的list
    volatile List<Object> list = new ArrayList<Object>();
    
    public void add (Object o){
        list.add(o);
    }
    
    public int size (){
        return list.size();
    }
    
    public static void main(String[] args) {
        final MyContainer01 c = new MyContainer01();
        
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    c.add(new Object());
                    System.out.println("add:" + i);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                
            }
        }, "t1").start();
        
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                while (true){
                    if(c.size() == 5)
                        break;
                }
                System.out.println("结束");
            }
        }, "t2").start();
    }
    
}
