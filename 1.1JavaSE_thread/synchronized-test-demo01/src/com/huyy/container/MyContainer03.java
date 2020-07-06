package com.huyy.container;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 但是上面代码也存在一个问题，t2是在t1执行结束之后才结束，而不是c.size（）==5时立刻结束。
 * 这是因为wait等待会释放锁，但是notify唤醒不会释放锁，所以才会导致t2要在t1之后才结束。
 * 这里我们就需要让t1线程运行notify唤醒其他线程之后再调用wait等待并释放锁，
 * 而t2线程需要结束之后再使用notify去唤醒其他线程
 */
public class MyContainer03 {

    //这里一定要加volatile，否则线程2无法监测到堆内存中 的list
    volatile List<Object> list = new ArrayList<Object>();
    
    public void add (Object o){
        list.add(o);
    }
    
    public int size (){
        return list.size();
    }
    
    public static void main(String[] args) {
        final MyContainer03 c = new MyContainer03();
        
        final Object lock = new Object();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("t2启动 ");
                    if(c.size() != 5){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("t2通知");
                    System.out.println("t2结束");
                    lock.notify();
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
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        c.add(new Object());
                        System.out.println("add:" + i);
                        if (c.size() == 5){
                            lock.notify();
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("t1停止");
            }
        }, "t1").start();
    }
}
