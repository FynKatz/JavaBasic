package com.huyy.container;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 但是上面的通讯太复杂了，如果只涉及到通讯而不涉及到同步时 synchronized wait/notify就会显得太重了，
 * 这时就应该考虑使用countdownlatch/cyclicbarrier/semaphore，
 * 使用Latch（门闩）代替wait notify来进行通知，好处是通信方式简单，同时还可以指定等待时间，
 * 使用await和countdown方法代替wait和notify，CountDownLatch不涉及锁定，
 * 当count的值为零时当前线程继续运行。
 */
public class MyContainer04 {

    volatile List<Object> list = new ArrayList<Object>();
    
    public void add (Object o){
        list.add(o);
    }
    
    public int size (){
        return list.size();
    }
    
    public static void main(String[] args) {
        final MyContainer04 c = new MyContainer04();
        
        final CountDownLatch lock = new CountDownLatch(1);//初始化门闩，当值为0时门闩就打开
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2启动 ");
                if(c.size() != 5){
                    try {
                        lock.await();//门闩的等待不需要锁定任何对象
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2通知");
                System.out.println("t2结束");
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
                for (int i = 0; i < 10; i++) {
                    c.add(new Object());
                    System.out.println("add:" + i);
                    if (c.size() == 5){
                        lock.countDown();//调用countDown，值为0，门闩就打开了
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t1停止");
            }
        }, "t1").start();
    }
}
