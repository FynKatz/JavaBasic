package com.huyy.CallableExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class CallableTest01 implements Callable<Object> {

    private int taskNum;

    public CallableTest01(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public Object call() throws Exception {
        Date dateTmp1 = new Date();
        Thread.sleep(1000);
        Date dateTmp2 = new Date();
        long time = dateTmp2.getTime() - dateTmp1.getTime();
        return taskNum + "任务返回运行结果    用时：" + time + "ms";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("----程序开始运行----");
        Date date1 = new Date();
        int taskSize=5;
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);//新建线程池
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            Callable c = new CallableTest01(i);
            Future f = pool.submit(c);// 执行任务并获取Future对象
            list.add(f);//存储执行结果
        }

        // 关闭线程池
        pool.shutdown();

        // 获取所有并发任务的运行结果
        for (Future f : list) {
            // 从Future对象上获取任务的返回值，并输出到控制台
            System.out.println(">>>" + f.get().toString()); //OPTION + return 抛异常
        }

        Date date2 = new Date();
        System.out.println("----程序结束运行----");
        System.out.println("程序运行时间：" + (date2.getTime() - date1.getTime()) + "ms");

    }
}
