package com.huyy.CallableExample;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class CallableExample implements Callable {
    @Override
    public Object call() throws Exception {
        Random generator = new Random();
        Integer randomNumber = generator.nextInt(5);
        Thread.sleep(randomNumber * 1000);
        return randomNumber;
    }
}

public class CallableTest02 {

    public static void main(String[] args) throws Exception {

        Date date1 = new Date();

        FutureTask[] randomNumberTasks = new FutureTask[5];

        for (int i = 0; i < 5; i++) {
            Callable callable = new CallableExample();
            randomNumberTasks[i] = new FutureTask(callable);

            new Thread(randomNumberTasks[i]).start();//启动线程
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("线程"+i+"已休眠："+randomNumberTasks[i].get()+"s，已终止");
        }

        Date date2 = new Date();
        System.out.println("程序运行时间：" + (date2.getTime() - date1.getTime()) + "ms");
    }
}
