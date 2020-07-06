package com.huyy.concurrentCollection;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/** CopyOnWriteList写时复制：
 * 添加元素的时候，会把这个容器复制一份，在复制的那份后面加一个新的，将引用指向复制的那份。
 * 适合写的很少，读的特别多的时候。 
 **/
public class CopyOnWriteListTest {
    public static void main(String[] args) {
        List<String> list =
//                new ArrayList<>();  //这个会出并发问题
//                new Vector<>(); //线程安全的容器
                new CopyOnWriteArrayList<>(); //线程安全，写效率很低
        
        Random r = new Random();
        Thread[] threads = new Thread[100];
        for (int i=0; i<threads.length; i++) {  //起100个线程，每个线程向容器中加1000个数（最终应该是10万个数）
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    for (int j=0; j<1000; j++) 
                        list.add("a" + r.nextInt());
                }
            };
            threads[i] = new Thread(task);
        }
        runAndComputeTime(threads);
        System.out.println(list.size());
    }
 
    //执行测试时间函数
    static void runAndComputeTime(Thread[] threads) {
        long start = System.currentTimeMillis();
        Arrays.asList(threads).forEach(t->t.start());
        Arrays.asList(threads).forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}