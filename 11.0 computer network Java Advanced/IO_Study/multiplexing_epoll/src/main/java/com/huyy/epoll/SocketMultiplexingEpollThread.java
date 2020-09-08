package com.huyy.epoll;


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
 *  epoll
 * */
public class SocketMultiplexingEpollThread {

    private ServerSocketChannel server = null;
    private Selector selector = null;//Linux多路复用器 （select poll , epoll）
    int port = 9090;

    public static void main(String[] args) throws IOException {
        SocketMultiplexingEpollThread service = new SocketMultiplexingEpollThread();
        service.start();
    }

    public void initServer(){
        try {
            //server监听listen状态
            server = ServerSocketChannel.open();
            server.configureBlocking(false);//server非阻塞
            server.bind(new InetSocketAddress(port));

            //如果在epoll模型下， open --> epoll_create -> fd3
            selector = Selector.open();// select poll *epoll 优先选择epoll 但是可以-D修正

            // server 约等于 listen 状态的 fd4
            /*
            register
            如果：
            select , poll: jvm里开辟一个数组 fd4放进去
            epoll: epoll_ctl(fd3, ADD, fd4, EPOLLIN
             */
            server.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException {
        initServer();
        System.out.println("服务器启动了。。。");
        while (true){
            Set<SelectionKey> keys = selector.keys();
            System.out.println(keys.size() + "  size");

            //1, 调用多路复用器（select, poll  or epoll(epoll_wait))
            /*
            select() 是啥意思：
            1. select, poll 其实是 内核的select
            2. epoll: 其实内核的 epoll_wait()
             */

            while (selector.select(500) > 0 ){
                Set<SelectionKey> selectionKeys = selector.selectedKeys(); //返回的有状态的fd集合
                Iterator<SelectionKey> iter = selectionKeys.iterator();

                while (iter.hasNext()){
                    SelectionKey key = iter.next();
                    iter.remove();
                    if(key.isAcceptable()){
                        //
                        acceptHandler(key);
                    }else if(key.isReadable()){
                        readHandler(key);
                    }
                }
            }
        }
    }

    private void readHandler(SelectionKey key) {
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.clear();
        int read = 0;

        while (true){

        }
    }

    private void acceptHandler(SelectionKey key) {

        try {
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            SocketChannel client = null;
            client = ssc.accept();//接收客户端 fd7
            client.configureBlocking(false);//非阻塞
            ByteBuffer buffer = ByteBuffer.allocate(8192);

            /*
            register
            如果：
            select , poll: jvm里开辟一个数组 fd7放进去
            epoll: epoll_ctl(fd3, ADD, fd7, EPOLLIN
             */
            client.register(selector, SelectionKey.OP_READ, buffer);
            System.out.println("新客户端：" + client.getRemoteAddress());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

