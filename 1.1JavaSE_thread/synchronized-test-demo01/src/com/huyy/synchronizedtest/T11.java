package com.huyy.synchronizedtest;

/**
 * volatile关键字，使一个变量在多个线程中可见。
 */
public class T11 {
    volatile boolean running = true; // 对比一下有无volatile的情况下，整个程序运行结果的区别

    void m() {
        System.out.println("m start");
        while (running) { // 死循环。只有running=false时，才能执行后面的语句

        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        T11 t11 = new T11();
        new Thread(()->t11.m(), "t1").start();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        t11.running = false; // 若running不被volatile关键字修饰时，线程“看不见”running被修改了
    }
}
