package com.huyy.concurrentCollection;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        Map<String,String> map = new ConcurrentHashMap<>();
//        Map<String,String> map = new ConcurrentSkipListMap<>(); //高并发且排序
 
 
//        Map<String,String> map = new Hashtable<>();  //速度慢点
//        Map<String,String> map = new HashMap<>();    //速度慢点
//        Map<String,String> map = new TreeMap<>();    //插入时要排序，所以插入可能会比较慢
 
        Random r = new Random();
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);  //门闩计数器  100
        
        long start = System.currentTimeMillis(); 
        
        for (int i=0; i<threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j=0; j<10000; j++) {  //向map中加入1万个随机字符串
                    map.put("a" + r.nextInt(100000),"a"+r.nextInt(100000));
                }
                latch.countDown();  //每执行完一个线程，就countdown一次
            });
        }
        
        Arrays.asList(threads).forEach(t->t.start());  //所有线程启动
        
        try {
            latch.await(); //主线程在这等着，直到countdown到0
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        long end = System.currentTimeMillis();  
        System.out.println(end - start);  //计算程序执行时间
    }
}
