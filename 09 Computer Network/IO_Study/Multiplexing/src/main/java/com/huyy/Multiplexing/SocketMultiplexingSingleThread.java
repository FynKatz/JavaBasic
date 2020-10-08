package com.huyy.Multiplexing;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/*
* 单线程的多路复用器
* */
public class SocketMultiplexingSingleThread {
    private ServerSocketChannel server = null;

    private Selector selector = null;//底层多路复用器的实现
    int port = 8090;

    public static void main(String[] args) {
        SocketMultiplexingSingleThread service = new SocketMultiplexingSingleThread();
        service.start();
    }

    public void initServer() {
        try {
            server = ServerSocketChannel.open();//开启server端
            server.configureBlocking(false);//非阻塞
            server.bind(new InetSocketAddress(port));//绑定端口8090

            selector = Selector.open();//jdk封装的selector
            server.register(selector, SelectionKey.OP_ACCEPT);//server注册selector
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        initServer();
        System.out.println("server started.");
        try {
            while(true){

                // 询问内核活动的fd集合
                while(selector.select(0) > 0) {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys(); // 返回的有状态的fd集合
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if(key.isAcceptable()) { //判断是可接收的
                            acceptHandler(key);
                        } else if(key.isReadable()) {//判断是可读取的
                            System.out.println("用户数据到达就会触发， 但是何时会疯狂触发呢？");
                            readHandler(key);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void acceptHandler(SelectionKey key) {
        try {
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            SocketChannel client = ssc.accept();//读取客户端
            client.configureBlocking(false);//设置客户端为非阻塞
            ByteBuffer buffer = ByteBuffer.allocate(4096);
            client.register(selector, SelectionKey.OP_READ, buffer);//注册新的客户端
            System.out.println("----------------------------------------");
            System.out.println("new client accepted: " + client.getRemoteAddress());
            System.out.println("----------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readHandler(SelectionKey key) {
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.clear();
        int read = 0;
        try {
            while (true) {
                read = client.read(buffer);
                if(read > 0) {
                    buffer.flip();
                    while(buffer.hasRemaining()) {
                        client.write(buffer);
                    }
                    buffer.clear();
                } else if(read == 0) {
                    break;
                } else { // 如果没有这段，服务端泡在linux环境中时，当客户端暴力断开连接后，上面的 readHandler(key) 会一直被调用。
                    client.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
