package com.huyy.concurrentCollection;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {
    static DelayQueue<MyTask> tasks = new DelayQueue<>();
 
    static class MyTask implements Delayed {  //实现Delayed接口
        long runningTime;
        String name;
        MyTask(long rt,String name) {
            this.runningTime = rt;
            this.name = name;
        }
 
        @Override
        public long getDelay(TimeUnit unit) { 
            return unit.convert(runningTime-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }
 
        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS))
                return -1;
            else if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS))
                return 1;
            else  // ==
            return 0;
        }
 
        @Override
        public String toString() {
            return name + "--" + runningTime;
        }
    }
 
    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        MyTask t1 = new MyTask(now + 1000, "task1"); //1 s 后执行
        MyTask t2 = new MyTask(now + 2000, "task2"); //2 s后执行
        MyTask t3 = new MyTask(now + 1500, "task3"); //1.5s后执行
        MyTask t4 = new MyTask(now + 500, "task4");  //0.5s后执行
        MyTask t5 = new MyTask(now + 2500, "task5"); //2.5s后执行
 
        //下面是按照时间顺序存入queue
        tasks.put(t1);
        tasks.put(t2);
        tasks.put(t3);
        tasks.put(t4);
        tasks.put(t5);
 
        System.out.println(tasks);
        for (int i=0; i<5; i++) {
            try {
                System.out.println(tasks.take()); //按放进去的顺序拿出
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
