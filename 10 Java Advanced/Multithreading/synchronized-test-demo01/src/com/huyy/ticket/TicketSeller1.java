package com.huyy.ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * 有1000张火车票，每张火车票都有一个编号，同时有10个窗口对外售票。
 * 下面的程序有什么问题？重复销售？
 */
public class TicketSeller1 {

    static List<String> tickets = new ArrayList<String>();
    
    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票编号：" + i);
        }
    }
    
    public static void main(String[] args) {
        //10个窗口
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (tickets.size() > 0){
                    System.out.println("销售了---"+tickets.remove(0));
                }
            }, "窗口" + i).start();
        }
    }
}
