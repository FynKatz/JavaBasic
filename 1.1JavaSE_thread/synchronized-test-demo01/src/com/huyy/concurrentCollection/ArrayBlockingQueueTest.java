package com.huyy.concurrentCollection;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/*有界阻塞式队列*/
public class ArrayBlockingQueueTest {
    static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10); // 最多装10个
    static Random r = new Random();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            try {
                strs.put("a" + i); // 向容器中添加10个，就满了
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 1.发现满了，就会等待，程序阻塞(停着不动)
         strs.put("aaa");
        // 2.已经满了，再往里面装就会报异常
        strs.add("aaa");
        // 3.1） 不会报异常，但是加不进去，返回是否添加成功
         strs.offer("aaa");
        // 3.2） 1秒钟后加不进去，就不往里面加了
         strs.offer("aaa", 1, TimeUnit.SECONDS);

        System.out.println(strs);
    }
}
