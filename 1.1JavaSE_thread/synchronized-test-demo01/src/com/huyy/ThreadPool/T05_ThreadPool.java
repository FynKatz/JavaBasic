package com.huyy.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class T05_ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        //一个固定大小为5的线程池，里面有6个任务，必定有一个线程要执行两个任务
        for (int i = 0; i < 6; i++) {
            service.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());//打印线程名称
            });
        }
        System.out.println(service);//第一次打印线程池
        
        service.shutdown();//关闭线程池（一个过程）
        System.out.println(service.isTerminated());//是否执行结束
        System.out.println(service.isShutdown());//是否关闭
        System.out.println(service);//第二次打印线程池
        
        TimeUnit.SECONDS.sleep(5);
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println(service);//第三次打印线程池
    }
}
