package com.huyy.concurrentCollection;

import java.util.concurrent.LinkedTransferQueue;

/*消费者先启动，生产者生产一个东西的时候，不扔在队列里，而是直接去找有没有消费者，有的话直接扔给消费者，
若没有消费者线程，调用transfer()方法就会阻塞，调用add()、offer()、put()方法不会阻塞。*/
public class TransferQueueTest {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();

        // 消费者先启动
        new Thread(() -> {
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.transfer("aaa");// 针对transfer()方法。如果后启动消费者，那么此处会阻塞

        strs.put("aaa");
        strs.add("aaa");
        strs.offer("aaa");// 针对put(),add(),offer()等方法。如果后启动消费者，此处不会阻塞。
        
        // 消费者后启动
       /* new Thread(() -> {
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();*/
    }
}
