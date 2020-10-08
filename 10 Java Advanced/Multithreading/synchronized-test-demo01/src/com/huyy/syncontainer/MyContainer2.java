package com.huyy.syncontainer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lock和 Condition实现，Condition方法可以精确的唤醒某些线程。
 */
public class MyContainer2<T> {

    final private LinkedList<T> list = new LinkedList<T>();
    final private static int MAX = 10;
    private int conut = 0;
    
    private Lock lock = new ReentrantLock();
    
    private Condition producer = lock.newCondition();//生产者锁
    private Condition consumer = lock.newCondition();//消费者锁
    
    public int getCount (){
        return this.conut;
    }
    //生产者生产
    public void put (T t){
        try {
            lock.lock();
            while (this.list.size() == MAX){
                producer.await();
            }
            this.list.add(t);
            this.conut++;
            this.consumer.signalAll();//通知消费者线程开始消费
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    //消费者消费
    public T get(){
        T t = null;
        try {
            lock.lock();
            while (this.list.size() == 0){
                consumer.await();
            }
            t = this.list.removeFirst();
            this.conut--;
            producer.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        } 
        return t;
    }
    
    public static void main(String[] args) {
        final MyContainer2<String> c = new MyContainer2<String>();
        
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                
                @Override
                public void run() {
                    while(true){
                        System.out.println(c.get());
                    }
                }
            }, "c" + i).start();
        }
        
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                
                @Override
                public void run() {
                    while(true){
                        c.put(Thread.currentThread().getName());
                    }
                }
            }, "p" + i).start();
            
        }
    }
    
}
