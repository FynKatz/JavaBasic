package com.huyy.ThreadPool;

import java.util.concurrent.*;

public class T04_Future {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        //方案1
        //FutureTask里面包装的是Callable,泛型是其中call()方法的返回值类型
        FutureTask<Integer> task = new FutureTask<>(()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        }); //上述lambda表达式相当于new Callable () { Integer call(){}}
        
        new Thread(task).start();
        
        System.out.println(task.get()); //阻塞等待着前面消息返回的值
        
        
        //方案2
        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<Integer> f = service.submit(()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return 1;
        });
        System.out.println(f.get());//阻塞等待着前面消息返回的值
        System.out.println(f.isDone());//释放
        
    }
}


