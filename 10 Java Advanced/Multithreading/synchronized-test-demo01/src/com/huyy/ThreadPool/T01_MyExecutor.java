package com.huyy.ThreadPool;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

public class T01_MyExecutor {

    public static void main(String[] args) {

//        DirectExecutor executor = new DirectExecutor();
        ThreadPerTaskExecutor executor = new ThreadPerTaskExecutor();
        SerialExecutor serialExecutor = new SerialExecutor(executor);
        serialExecutor.execute(()-> System.out.println("executor"));

    }
}

/**
 * 同步执行任务
 */
class DirectExecutor implements Executor {

    @Override
    public void execute(Runnable command) {
        command.run();
    }
}

/**
 * 异步执行任务
 */
class ThreadPerTaskExecutor implements Executor {

    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}

/**
 * 对任务进行排队执行
 */
class SerialExecutor implements Executor {
    final Queue<Runnable> tasks = new ArrayDeque<>();
    final Executor executor;
    Runnable active;
    //构造器
    SerialExecutor(Executor executor) {
        this.executor = executor;
    }

    @Override
    public synchronized void execute(Runnable command) {
        tasks.offer(new Runnable() {
            @Override
            public void run() {
                try {
                    command.run();
                }finally {
                    scheduleNext();
                }
            }
        });

        if (active == null){
            scheduleNext();
        }
    }

    protected synchronized void scheduleNext() {
        if ((active = tasks.poll()) != null) {
            executor.execute(active);
        }
    }
}
