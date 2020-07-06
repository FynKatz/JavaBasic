package com.huyy.reentrantLock;

/**
 * 两个synchronized方法同时执行。
 */
public class ReentrantLock01 {

    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName() + "m1 start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m1 end");
    }
    public synchronized void m2 (){
        System.out.println(Thread.currentThread().getName() + "m2 start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m2 end");
    }

    public static void main(String[] args) {
        final ReentrantLock01 r01 = new ReentrantLock01();
        new Thread(()->r01.m1(), "thread1：").start();
        new Thread(()->r01.m2(), "thread2：").start();
    }
}
