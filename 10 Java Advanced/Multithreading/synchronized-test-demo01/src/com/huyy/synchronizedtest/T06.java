package com.huyy.synchronizedtest;

/**
 * synchronized方法与非synchronized方法可以同时运行么？
 */
public class T06 {

    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName() + "m1 start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m1 end");
    }
    public synchronized void m2 (){
        System.out.println(Thread.currentThread().getName() + "m2 start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m2 end");
    }

    public static void main(String[] args) {
        final T06 t06 = new T06();
        new Thread(()->t06.m1(), "thread1：").start();
        new Thread(()->t06.m2(), "thread2：").start();
    }
}
