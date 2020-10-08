package com.huyy.synchronizedtest;

/**
 * synchronized关键字，对static对象加锁
 */
public class T04 {

    private static int count = 10;

    public synchronized static void test() {// synchronized用在static静态方法上
        count--;
        System.out.println(Thread.currentThread().getName() + " count:" + count);
    }

    public static void test2() {
        synchronized (T04.class) {// 等价于上面的test()写法。
            count--;
            System.out.println(Thread.currentThread().getName() + " count:" + count);
        }
    }

    public static void main(String[] args) {
        new Thread(() -> T04.test2()).start();
        new Thread(() -> T04.test2()).start();
    }
}
