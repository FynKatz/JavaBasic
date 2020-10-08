package com.huyy.syncontainer;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class MyContainer1<T> {

    private final LinkedList<T> lists = new LinkedList<T>(); 
    private final static int MAX = 10;
    private int count = 0;
    
    public int getCount (){
        return this.count;
    }
    
    public synchronized void put (T t){
        
        // 问题1：这里为什么使用while而不是if？
        /*
         * 假设有两个线程同时等着put()，当某个消费者消费一个后，同时通知这两个线程，此时两个线程同时被唤醒。
         * 1.如果是if，那么他们因为只有一次的判断机会，此时都判断为非满的状态（不执行wait语句，就处于非阻塞的状态）。
         * 第一个线程(拿到锁后)会往里put一个（此时容器满了），但是因为第二个线程已经判断没有满，（拿到锁后）会继续put一个，
         * 此时，该容器就会溢出。 
         * 2.但是如果是while，那么第二个线程（拿到锁后）在put前会“再一次判断是否满”，因为此时是满的状态，只有继续等待。
         */
        while (lists.size() == MAX){
            try {
                this.wait();//effective java中说，wait()99%都和while一起用
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lists.add(t);
        count++;
        
        // 问题2：为什么是notifyAll而不是notify？因为如果只叫醒一个线程，万一叫醒的是put的线程，那么就会一直阻塞。
        /*
         * 解释：假设前面所有的消费者，消耗完所有的容器后，都处于释放锁的(阻塞)状态。 
         * 现在突然来了10个生产者，依次被叫醒、put后存满了容器。
         * 如果第10个生产者的通知还是通知了一个生成者，而此时唯一活着的put线程也处于阻塞状态，整个程序处于阻塞的状态。
         */
        this.notifyAll();//通知消费者线程进行消费。effective java中说，99%都使用notifyAll而不是用notify
    }
    
    public synchronized T get(){
        T t = null;
        while (lists.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = lists.removeFirst();
        count--;
        this.notifyAll();//通知生产者线程进行生产
        return t;
    }
    
    
    public static void main(String[] args) {
        final MyContainer1<String> container = new MyContainer1<String>();
        for (int i = 0; i < 10; i++) {
            //消费者线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j=0;j<5;j++)System.out.println(container.get());
                }
            }, "c消费者：" + i).start();
        }
        
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 2; i++) {
            //生产者线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 25; j++) {
                        container.put(Thread.currentThread().getName());
                    }    
                }
            }, "p生产者：" + i).start();
        }
    }
}
