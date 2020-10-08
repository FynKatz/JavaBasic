package com.huyy.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
* ReentrantLock还可以设置公平锁
*/
public class ReentrantLock05 extends Thread{

//   private static ReentrantLock lock = new ReentrantLock();//默认为非公平锁
   private static ReentrantLock lock = new ReentrantLock(true);//true为公平锁
   public void run (){
       for (int i = 0; i < 100; i++) {
           lock.lock();
           try {
               System.out.println(Thread.currentThread().getName() + "获得锁");
           } catch (Exception e){
               e.printStackTrace();
           } finally{
               lock.unlock();
           }
       }
   }
   
   public static void main(String[] args) {
       ReentrantLock05 r5 = new ReentrantLock05();
       new Thread(r5, "t2").start();
       new Thread(r5, "t1").start();
   }
}
