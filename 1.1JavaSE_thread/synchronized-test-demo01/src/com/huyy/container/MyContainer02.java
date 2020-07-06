package com.huyy.container;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 这里就要使用wait和notify做到，
 * wait会让t2对象进入等待状态并且释放锁，而t1在执行到
 * c.size（）==5时使用notify唤醒等待的线程。
 * 需要注意的是，这种方法必须要让t2先执行，也就是先让t2监听才可以
 */
public class MyContainer02 {

    //这里一定要加volatile，否则线程2无法监测到堆内存中 的list
    volatile List<Object> list = new ArrayList<Object>();
    
    public void add (Object o){
        list.add(o);
    }
    
    public int size (){
        return list.size();
    }
    
    public static void main(String[] args) {
        final MyContainer02 c = new MyContainer02();
        
        final Object lock = new Object();//定义wait和notify的操作对象
        
        /*必须先启动t2线程，使其在等待的状态，再启动t1线程*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {//必须锁定对象
                    System.out.println("t2启动 ");
                    if(c.size() != 5){//只是叫醒一次，所有用if而不用while
                        try {
                            lock.wait();//wait()释放锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("t2通知");
                    System.out.println("t2结束");
                }
            }
        }, "t2").start();
        
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
        }
        
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                System.out.println("t1启动");
                synchronized (lock) {//必须锁定对象
                    for (int i = 0; i < 10; i++) {
                        c.add(new Object());
                        System.out.println("add:" + i);
                        if (c.size() == 5){
                            lock.notify();//notify不释放锁，
                        }
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("t1结束");
            }
        }, "t1").start();
    }
}
