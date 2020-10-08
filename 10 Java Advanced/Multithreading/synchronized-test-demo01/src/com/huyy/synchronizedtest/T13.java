package com.huyy.synchronizedtest;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile并不能保证多个线程共同修改running变量时所带来的不一致问题， 也就是说volatile不能替代synchronized
 */
public class T13 {
    volatile int count = 0;

    public synchronized void m() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<Thread>();
        final T13 t = new T13();

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
