package com.huyy.synchronizedtest;

/**
 * 一个同步方法可以调用另一个同步方法，一个线程已经拥有某个对象的锁，
 * 再次申请时任然会获得该对象的锁，也就是说synchronized的锁是可以重入的。
 */
public class T08 {

    synchronized void m1 (){
        System.out.println("m1 start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println("m1 end");
    }
    
    synchronized void m2 (){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }
    
    public static void main(String[] args) {
        T08 t08 =new T08();
        new Thread(()->t08.m1()).start();
    }
}
