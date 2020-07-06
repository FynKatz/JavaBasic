package com.huyy.concurrentCollection;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new ConcurrentLinkedQueue<String>();
        for (int i = 0; i < 10; i++) {
          //类似于add方法，但是offer方法不会抛异常，返回boolean类型即是否添加成功
            queue.offer(""+ i );
        }
        System.out.println(queue);
        System.out.println(queue.size());
        //删除头
        System.out.println(queue.poll());
        System.out.println(queue.size());
        //拿出头，但是不删除
        System.out.println(queue.peek());
        System.out.println(queue.size());
    }
}
