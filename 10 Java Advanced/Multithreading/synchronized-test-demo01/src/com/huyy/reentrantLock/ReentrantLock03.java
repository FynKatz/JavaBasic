package com.huyy.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 使用ReentrantLock可以进行尝试锁定tryLock();
 * 若无法锁定或在指定时间内无法锁定，线程可以决定是否等待。
 * */
public class ReentrantLock03 {
    
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

    //使用tryLock锁定尝试锁定，不管是否锁定，方法都将继续执行。也可以根据tryLock的返回值来判断是否锁定
    void m2() {
        // trylock方式1
//        boolean locked = lock.tryLock();
//        System.out.println(Thread.currentThread().getName() + "m2的locked值为："+locked);
//        if (locked)
//            lock.unlock(); // 不指定尝试时间

        // trylock方式2
        boolean locked02 = false;
        try {
            locked02 = lock.tryLock(5, TimeUnit.SECONDS); // 指定超时时间为5s
            System.out.println(Thread.currentThread().getName() + "m2的locked值为："+locked02);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (locked02) {
                lock.unlock();
            }
        }
    }
 
    public static void main(String[] args) {
        ReentrantLock03 r3 = new ReentrantLock03();
        new Thread(() -> r3.m1(), "thread1：").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() ->r3.m2(), "thread2：").start();
    }
}
