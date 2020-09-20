package com.huyy.BIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yyhu
 * @create 2020-09-16-21:25
 **/
public class BIOServer {

    public static void main(String[] args) throws IOException {
        //思路
        //1.创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        /*  应该手动创建
        *阿里并发编程规约：线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式手动创建。
        * ExecutorService threadPool=new ThreadPoolExecutor(2,5,1L,TimeUnit.SECONDS,new LinkedBlockingQueue<>(3),
        *                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        */

        //创建serversocket
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("server init...");

        //2.如果有客户端建立连接了，就创建一个线程与之通信（单独写方法）
        while (true){
            //监听，等待客户端的连接
            final Socket socket = serverSocket.accept();
            System.out.println("new client connected...");

            //创建一个线程与之通信（单独写方法）
            executorService.execute(new Runnable() {
                //重写
                public void run() {
                    //可以和客户端通信
                    handler(socket);
                }
            });

        }

    }

    /*和客户端通信*/
    private static void handler(Socket socket) {

        try {
            //接收数据的byte数组的缓存
            byte[] bytes = new byte[1024];
            //通过socket获取输入流
            InputStream inputStream = socket.getInputStream();

            //循环读取客户端的数据到缓存
            while (true){
                System.out.println("Thread：id "+Thread.currentThread().getId()
                        +"  name:"+Thread.currentThread().getName());
                int i = inputStream.read(bytes);
                if (i != -1){
                    //打印字节数组
                    System.out.println(new String(bytes,0,i));
                }else {
                    break;
                }

            }



        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //关闭socket
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
