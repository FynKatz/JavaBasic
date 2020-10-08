package com.huyy.BIO;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOSocket {

    public static void main(String[] args) throws Exception {
        //创建服务端，绑定端口8090
        ServerSocket serverSocket = new ServerSocket(8090);
        System.out.println("step1: new ServerSocket(8090) ");
        //循环接收不同客户端的连接
        while (true) {
            //当接收到一个客户端的时候
            Socket client = serverSocket.accept();//阻塞1
            System.out.println("step2: client\t"+client.getPort());
            //新启一个线程，输入数据并打印
            new Thread(() -> {
                try {
                    InputStream in = client.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    while (true) {
                        System.out.println(reader.readLine());//阻塞2
                    }
                } catch (Exception e) {
                }
            }).start();//启动线程
        }
    }
}
