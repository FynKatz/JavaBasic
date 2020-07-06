package com.huyy.concurrentCollection;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/*无界阻塞式队列*/
public class LinkedBlockingQueueTest {
    static BlockingQueue<String> strs = new LinkedBlockingQueue<>();
    static Random r = new Random();
    public static void main(String[] args) {
        new Thread(()->{  //1个生产者线程
            for (int i=0; i<100; i++) {
                try {
                    strs.put("a" + i);  //如果满了，就会等待
                    TimeUnit.MILLISECONDS.sleep(r.nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"producer").start();
 
        for (int i=0; i<5; i++) {  //5个消费者进程
            new Thread(()-> {
                for (;;) {
                    try {
                        System.out.println(Thread.currentThread().getName()
                                + " take-" + strs.take()); //如果空了，就等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"customer"+i).start();
        }
    }
}
