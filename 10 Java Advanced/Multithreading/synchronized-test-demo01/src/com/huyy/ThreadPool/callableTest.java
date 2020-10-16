package com.huyy.ThreadPool;


import java.util.concurrent.*;

public class callableTest implements Callable<String > {
    @Override
    public String call() {
        try{
            String str = "hello";
            return str;
        }
        catch(Exception e){
            e.printStackTrace();
            return "exception";
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10,100,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

        Future<String> future = threadPoolExecutor.submit(new callableTest());

        try{
            System.out.println(future.get());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            threadPoolExecutor.shutdown();
        }

    }
}
