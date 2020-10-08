package com.huyy.synchronizedtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 如果再操作中仅仅是数字的++，--等操作，java提高了一些原子操作的类AtomXXX类
 */
public class T14 {
    AtomicInteger count = new AtomicInteger(0);
    
    //这里可以不用synchronized，AtomicInteger方法内部使用了更底层的方式保证原子性
    /*synchronized*/ void m (){
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();//相当于count++，但是还保证原子性
        }
    }
    
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<Thread>();
        final T14 t = new T14();

        // 新建10个线程，同时去操作这个count
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(() -> t.m(), "Thread-" + i));
        }
        // 启动这10个线程
        // 也可写成threads.forEach((o)->o.start());
        for (Thread thread : threads) {
            thread.start();
        }

        // 让主线程等待（这10个）子线程运行结束之后（插队）再执行
        for (Thread thread : threads) {
            try {
                thread.join();// 让主线程等待子线程运行结束之后再执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(t.count);
    }
}
