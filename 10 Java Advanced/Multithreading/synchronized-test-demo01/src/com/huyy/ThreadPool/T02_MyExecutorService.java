package com.huyy.ThreadPool;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class T02_MyExecutorService{

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程池（这里执行的的方法newSingleThreadExecutor()，只做演示，具体细节下一节深究）
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        /*//执行execute()
        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });*/

        /*//执行
        Future future = executorService.submit(new Callable<Object>() {

            @Override
            public String call() throws Exception {
                System.out.println("Asynchronous task");
                return "done!";
            }
        });
        System.out.println(future.get());;//获取结果*/

        /*Set<Callable<String>> callables = new HashSet<>();

        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 1";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 2";
            }
        });


        String result = executorService.invokeAny(callables);
        System.out.println("result = " + result);*/

        Set<Callable<String>> callables = new HashSet<>();

        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 1";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 2";
            }
        });

        List<Future<String>> futures = executorService.invokeAll(callables);

        for(Future<String> future : futures){
            System.out.println("future.get = " + future.get());
        }

        //关闭线程池
        executorService.shutdown();

    }
}

