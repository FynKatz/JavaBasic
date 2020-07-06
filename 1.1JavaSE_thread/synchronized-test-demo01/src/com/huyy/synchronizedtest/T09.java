package com.huyy.synchronizedtest;

/**
 * 继承中，子类调用父类的同步方法。
 */
public class T09 {

    synchronized void m() {
        System.out.println("m start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {

        TT tt = new TT();
        new Thread(() -> tt.m()).start();
    }
}

class TT extends T09 {
    @Override
    synchronized void m() {
        System.out.println("child m stard");
        super.m();//在继承中，子类同步方法可以调用父类的同步方法
        System.out.println("child m end");
    }
}
