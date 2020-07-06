package com.huyy.synchronizedtest;

/**
 * 程序在执行过程中，如果遇到异常，默认情况所会被释放，
 * 所以，在并发编程中，有异常要多加小心，不然可能会发生不一致的情况。
 */
public class T10 {
    int count = 0;
    
    synchronized void m(){
        System.out.println(Thread.currentThread().getName()+" start");
        
        while (true){
            count ++;
            System.out.println(Thread.currentThread().getName()+ " count=" + count);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            if (count == 5){
                int i = 1/0;//这里会产生异常，导致锁释放，如果不想让锁释放需要捕获异常
            }
        }
    }
    
    public static void main(String[] args) {
        final T10 t = new T10();
        new Thread(()-> t.m(), "T1").start();
        new Thread(()-> t.m(), "T2").start();
    }
}
