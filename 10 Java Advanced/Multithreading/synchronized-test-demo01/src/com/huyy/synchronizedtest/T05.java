package com.huyy.synchronizedtest;

/**
 * 在实现Runnable的线程类中，对run()应用synchronized
 */
public class T05 implements Runnable{

    private int count = 10;
    
    @Override
    public synchronized void run() {
        count--;
        
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " count:" + count);
    }

    public static void main(String[] args) {
        T05 t = new T05();
        
        //这里只创建一个T05的对象，后面循环创建5个线程来访问同一个对象，所有操作的都是针对同一个count值。
        for (int i=0; i<5 ; i++){
            new Thread(t, "thread" +i).start();
        }
    }
}
