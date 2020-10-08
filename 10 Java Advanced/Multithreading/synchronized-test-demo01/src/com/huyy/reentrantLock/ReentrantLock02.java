package com.huyy.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantLock可以完成synchronized做的同样的功能，但是需要手工释放锁。
 * 使用synchronized的时候遇到异常jvm会自动释放锁。
 * 但是reentrantLock不会自动释放，需要手动去释放锁，所以一般是将释放锁写到finally里面的。
 */
public class ReentrantLock02 {
    
    Lock lock = new ReentrantLock();//新建一个Lock类对象
    void m1 (){
        try {
            lock.lock();//相当于synchronized（this）
            System.out.println(Thread.currentThread().getName() + "m1 start");
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println(Thread.currentThread().getName() + "m1 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//reentrantLock需要释放锁
        }
    }
    
    void m2 (){
        //如果想要两个方法互斥，则锁定同一把锁即可
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "m2 start");
        lock.unlock();
        System.out.println(Thread.currentThread().getName() + "m2 end");
    }
    
    public static void main(String[] args) {
        final ReentrantLock02 r2 = new ReentrantLock02();
        new Thread(()->r2.m1(), "thread1：").start();
        
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        new Thread(()->r2.m2(), "thread2：").start();
    }
}
