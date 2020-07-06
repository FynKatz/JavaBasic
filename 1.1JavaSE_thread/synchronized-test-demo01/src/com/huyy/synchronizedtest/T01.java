package com.huyy.synchronizedtest;

/**
 * synchronized关键字，对某个对象加锁
 */
public class T01 {

    private int count = 10;
    private Object obj = new Object();

    public void test() {
        synchronized (obj) {// 任何线程想要执行下面代码就必须先要拿到obj的锁。
            count--;
            System.out.println(Thread.currentThread().getName() + " count:" + count);
        }
    }

    public static void main(String[] args) {
        T01 t01 = new T01();

        new Thread(new Runnable() { //原本的lambda表达式
            @Override
            public void run() {
                t01.test();
            }
        }).start();
        
        new Thread(() -> t01.test()).start();//简写的lambda表达式
        new Thread(() -> t01.test()).start();
    }
}
