package com.huyy.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class T08_SingleThreadPool {
public static void main(String[] args) throws InterruptedException {
    	
        ExecutorService service = Executors.newSingleThreadExecutor();
        
        for (int i = 0; i < 2; i++) {
        	final int c = i;//必须是final，后面才能打印
            service.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(c+" "+Thread.currentThread().getName());
            });
        }
       
        
    }
}
