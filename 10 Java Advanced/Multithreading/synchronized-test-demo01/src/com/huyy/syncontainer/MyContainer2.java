package com.huyy.syncontainer;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
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

    //生产者锁
    private Condition producer = lock.newCondition();
    //消费者锁
    private Condition consumer = lock.newCondition();
    
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
        final MyContainer2<String> container2 = new MyContainer2<>();

        for (int i = 0; i < 10; i++) {
            //消费者线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j=0;j<5;j++) {
                        String str = container2.get();
                        System.out.println(Thread.currentThread().getName()+" 消费："+str);
                    }
                }
            }, "消费者" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 2; i++) {
            //生产者线程
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 25; j++) {
                        String str = finalI+"-"+j;
                        container2.put(str);//生产
                        System.out.println(Thread.currentThread().getName()+" 生产："+str);
                    }
                }
            }, "生产者" + i).start();
        }
    }
    
}
