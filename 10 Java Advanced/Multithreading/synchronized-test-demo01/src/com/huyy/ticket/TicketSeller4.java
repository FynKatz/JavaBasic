package com.huyy.ticket;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TicketSeller4 {
    static Queue<String> tickets = new ConcurrentLinkedQueue<>();
    static {
        for (int i=0; i<1000; i++) {
            System.out.println("票编号：" + i );
        }
    }
 
    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            new Thread( ()-> {
                while(true) {
                    String str = tickets.poll(); //poll方法是原子性的，拿出一张票
                    if (str == null)
                        break;
                    else
                        System.out.println("销售了.." + str);
                }
            }).start();
        }
    }
}
