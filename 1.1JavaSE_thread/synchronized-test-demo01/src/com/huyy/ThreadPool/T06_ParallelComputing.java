package com.huyy.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
 
public class T06_ParallelComputing {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        long start = System.currentTimeMillis();
//        List<Integer> results = getPrime(1, 200000); 
//        long end = System.currentTimeMillis();
//        System.out.println("使用一个线程，经历的时间为："+(end - start));
        
        final int cpuCoreNum = 4;//计算机有几个核，就用几个线程
        
        ExecutorService service = Executors.newFixedThreadPool(cpuCoreNum);
        
        MyTask t1 = new MyTask(1, 80000); //1-5 5-10 10-15 15-20
        MyTask t2 = new MyTask(80001, 130000);
        MyTask t3 = new MyTask(130001, 170000);
        MyTask t4 = new MyTask(170001, 200000);
        
        Future<List<Integer>> f1 = service.submit(t1);
        Future<List<Integer>> f2 = service.submit(t2);
        Future<List<Integer>> f3 = service.submit(t3);
        Future<List<Integer>> f4 = service.submit(t4);
        
        long start2 = System.currentTimeMillis();
        f1.get();
        f2.get();
        f3.get();
        f4.get();
        long end2 = System.currentTimeMillis();
        System.out.println("使用多线程并行计算，经历的时间为："+(end2 - start2));
    }
    
    static class MyTask implements Callable<List<Integer>> {
        int startPos, endPos;
        
        MyTask(int s, int e) {
            this.startPos = s;
            this.endPos = e;
        }
        
        @Override
        public List<Integer> call() throws Exception {
            List<Integer> r = getPrime(startPos, endPos);
            return r;
        }
        
    }
    
    static boolean isPrime(int num) {
        for(int i=2; i<=num/2; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    
    static List<Integer> getPrime(int start, int end) {
        List<Integer> results = new ArrayList<>();
        for(int i=start; i<=end; i++) {
            if(isPrime(i)) results.add(i);
        }
        
        return results;
    }
}
