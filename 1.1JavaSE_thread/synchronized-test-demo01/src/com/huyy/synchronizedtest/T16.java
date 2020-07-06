package com.huyy.synchronizedtest;

import java.util.concurrent.TimeUnit;

public class T16 {

    int count = 0;
    synchronized void m1(){
        long startTime = System.currentTimeMillis();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //业务逻辑中只有下面代码需要同步，这时不应该给所有方法上锁
        count ++;
        
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("m1()用时"+(startTime-endTime)+"ms");
    }
    
    void m2(){
        long startTime = System.currentTimeMillis();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //采用细粒度的锁可以使线程争用时间变短，提高效率
        synchronized (this) {
            count ++;
        }
        
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("m2()用时"+(startTime-endTime)+"ms");
    }
    
    public static void main(String[] args) {
        T16 t1 = new T16();
        T16 t2 = new T16();
        
        new Thread(() -> t1.m1()).start();
        new Thread(() -> t2.m2()).start();
    }
}
