package com.huyy.ticket;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * 有1000张火车票，每张火车票都有一个编号，同时有10个窗口对外售票。
 * 使用线程安全的容器vector。
 */
public class TicketSeller3 {

    static Vector<String> tickets = new Vector<>();
    
    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票编号：" + i);
        }
    }
    
    public static void main(String[] args) {
        // 10个窗口
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    synchronized (tickets) {//对票集合加锁
                        if (tickets.size() <= 0) {
                            break;
                        }
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("销售了---" + tickets.remove(0));
                    }                    
                }
            }, "窗口" + i).start();
        }
    }
}
