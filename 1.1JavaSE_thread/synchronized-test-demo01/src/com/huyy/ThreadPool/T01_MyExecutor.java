package com.huyy.ThreadPool;

import java.util.concurrent.Executor;

public class T01_MyExecutor implements Executor {
    
    public static void main(String[] args) {
        new T01_MyExecutor().execute(()->System.out.println("hello executor"));
    }
 
    @Override
    public void execute(Runnable command) {
        //new Thread(command).run();  //新启一个线程去执行Runnable的run方法
        command.run();                //方法调用
    }
 
}
