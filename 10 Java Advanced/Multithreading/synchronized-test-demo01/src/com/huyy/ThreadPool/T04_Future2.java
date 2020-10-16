package com.huyy.ThreadPool;

import java.util.concurrent.*;

public class T04_Future2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ComplexTask task = new ComplexTask();
        Future<Double> future = new FutureTask<>(task);

        new Thread((FutureTask)future).start();

        Double result = future.get();
        System.out.println(result);
    }
}

class ComplexTask implements Callable<Double> {
    @Override
    public Double call() {
        // complex calculating...
        return Math.random();
    }
}
