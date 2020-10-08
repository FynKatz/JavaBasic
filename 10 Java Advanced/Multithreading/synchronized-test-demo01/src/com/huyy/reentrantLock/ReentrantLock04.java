package com.huyy.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock还可以使用lockInterruptibly方法可以对interrupt做出响应，
 * 在一个线程等待锁的过程中可以被打断。
 */
public class ReentrantLock04 {

    public static void main(String[] args) {
        
        Lock lock = new ReentrantLock();
        
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                try {
                    lock.lock();//因为t1锁定了同一个lock，因此t2线程一直不能被执行
                    System.out.println("t1 start");
                    TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);//会一直睡死
                    System.out.println("t1 end");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "thread1：").start();
        
        Thread t2 = new Thread(new Runnable() {
            
            @Override
            public void run() {
                try {
//                    lock.lock();//因为t1锁定了同一个lock，因此t2线程一直不能被执行
                    /* lockInterruptibly()方法可以对interrupt做出响应，在一个线程等待锁的过程中可以被打断。 */
                    lock.lockInterruptibly();
                    System.out.println("t2 start");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("t2 end");
                } catch (InterruptedException e) {
                    System.out.println("t2 Interrupt!");
                    e.printStackTrace();
                } finally {
                    System.out.println("unlock");
                    lock.unlock();
                }
            }
        }, "thread2：");
        t2.start();
        
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();//主线程中，3s后t2线程去打断
    }
}
