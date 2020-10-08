package com.huyy.synchronizedtest;

import java.util.concurrent.TimeUnit;

/**
 * 锁定某对象o，如果o的属性发生改变，不影响锁的使用
 * 但是如果o改变成另外一个对象，则锁定的对象发生变化，
 * 应该避免将锁定对象的引用变成另外的对象
 */
public class T17 {
    
    Object o = new Object();
    
    void m (){
        synchronized(o){
            while(true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
    
    public static void main(String[] args) {
        final T17 t = new T17();
        new Thread(()->t.m(), "t1").start();
        
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Thread t2 = new Thread(()->t.m(), "t2");
        //锁定的对象发生变化，当执行到这时发现new出来的o没有被锁定则t2开始执行，如果没有这句话
        //t2就永远不会执行
        t.o = new Object();
        t2.start();
    }

}
