package com.huyy.synchronizedtest;

/**
 * synchronized关键字，对自身对象this加锁
 */
public class T03 {

    private int count = 10;

    public synchronized void test() {//等同于在方法块中synchronized（this）{}
        count--;
        System.out.println(Thread.currentThread().getName() + " count:" + count);
    }

    public static void main(String[] args) {
        T03 t03 = new T03();

        new Thread(() -> t03.test()).start();
        new Thread(() -> t03.test()).start();
    }
}
