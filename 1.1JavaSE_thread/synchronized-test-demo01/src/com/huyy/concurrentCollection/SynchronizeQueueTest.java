package com.huyy.concurrentCollection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/*一种特殊的TransferQueue，生产的任何一个东西必须直接交给消费者消费，不能搁在容器里，容器的容量为0*/
public class SynchronizeQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> strs = new SynchronousQueue<>();
 
        new Thread(()->{  //消费者线程
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        
//        strs.add("aa");//不能调用add(报错)，add不进去
        strs.put("aaaa"); //只能使用put阻塞，等待消费者消费，其内部实际调用的transfer.
        System.out.println(strs.size());  //0
    }
}
