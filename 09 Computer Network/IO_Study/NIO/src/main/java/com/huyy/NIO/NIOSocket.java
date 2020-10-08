package com.huyy.NIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;


/**
 * NIO  同步非阻塞IO  调用方法一定有返回，或者NULL或者有连接client
 */
public class NIOSocket {
    public static void main(String[] args) throws Exception {

        LinkedList<SocketChannel> clients = new LinkedList<>();

        // 1. 创建socket
        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(9090));//绑定端口
        ss.configureBlocking(false);     // 设置为非阻塞  操作系统的NIO

        while (true) {

            Thread.sleep(1000);


            // 2. 非阻塞方式接受客户端连接
            SocketChannel client = ss.accept();

            // 3. 判断是否有客户端链接
            if (client == null) {
                //只有非阻塞，才会打印下面的null
                //System.out.println("null................");
            } else {
                client.configureBlocking(false); //客户端设置为非阻塞的
                int port = client.socket().getPort();
                System.out.println("client.....port: " + port);
                clients.add(client);
            }

            //可以在堆里 堆外
            ByteBuffer buffer = ByteBuffer.allocateDirect(4096);

            // 4. 遍历已经连接进来的客户能不能读写数据
            for (SocketChannel c : clients) {//串行化 多线程

                // 读取也为非阻塞，返回int 。
                int num = c.read(buffer);// 若大于0则有数据读取，无数据为0，断开连接-1.

                if (num > 0) {
                    buffer.flip();
                    byte[] aaa = new byte[buffer.limit()];
                    buffer.get(aaa);
                    String b = new String(aaa);
                    System.out.println(c.socket().getPort() + ":" + b);
                    buffer.clear();
                }
            }
        }
    }
}



