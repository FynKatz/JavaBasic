package com.huyy.synchronizedtest;

/**
 * synchronized关键字，对自身对象this加锁
 */
public class T02 {

    private int count = 10;
//    private Object obj = new Object();

    public void test() {
        synchronized (this) {// 任何线程想要执行下面代码就必须先要拿到自身this的锁。
            count--;
            System.out.println(Thread.currentThread().getName() + " count:" + count);
        }
    }

    public static void main(String[] args) {
        T02 t02 = new T02();

        new Thread(() -> t02.test()).start();
        new Thread(() -> t02.test()).start();
    }
}
