
package com.huyy.NIO.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class GroupChatServer {
    //定义属性
    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT = 6667;

    //构造器
    public GroupChatServer() {
        try {
            selector = Selector.open();//得到选择器
            listenChannel =  ServerSocketChannel.open();//ServerSocketChannel
            listenChannel.socket().bind(new InetSocketAddress(PORT));//绑定端口
            listenChannel.configureBlocking(false);//设置非阻塞模式
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);//将该listenChannel 注册到selector
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    //监听
    public void listen() {

        System.out.println("监听线程: " + Thread.currentThread().getName());
        try {
            //循环处理
            while (true) {

                int count = selector.select();
                if(count > 0) {//有事件处理

                    //遍历得到selectionKey 集合
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {

                        SelectionKey key = iterator.next();
                        //如果是可连接
                        if(key.isAcceptable()) {
                            SocketChannel sc = listenChannel.accept();
                            sc.configureBlocking(false);
                            sc.register(selector, SelectionKey.OP_READ);
                            System.out.println(sc.getRemoteAddress() + " 上线 ");//提示
                        }
                        //如果是可读状态
                        if(key.isReadable()) {
                            readData(key);//处理读 (专门写方法..)
                        }

                        //当前的key 删除，防止重复处理
                        iterator.remove();
                    }

                } else {
                    System.out.println("等待....");
                }
            }

        }catch (Exception e) {
            e.printStackTrace();

        }finally {
            //发生异常处理....

        }
    }

    //读取客户端消息
    private void readData(SelectionKey key) {

        //取到关联的channle
        SocketChannel channel = null;

        try {

            channel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int count = channel.read(buffer);
            if(count > 0) {
                String msg = new String(buffer.array());
                System.out.println("form 客户端: " + msg);//输出该消息

                //向其它的客户端转发消息(去掉自己), 专门写一个方法来处理
                sendInfoToOtherClients(msg, channel);
            }

        }catch (IOException e) {
            try {
                System.out.println(channel.getRemoteAddress() + " 离线了..");
                //取消注册
                key.cancel();
                //关闭通道
                channel.close();
            }catch (IOException e2) {
                e2.printStackTrace();;
            }
        }
    }

    //转发消息给其它客户(通道)
    private void sendInfoToOtherClients(String msg, SocketChannel self ) throws  IOException{

        System.out.println("服务器转发消息中...");
        System.out.println("服务器转发数据给客户端线程: " + Thread.currentThread().getName());
        //遍历 所有注册到selector 上的 SocketChannel,并排除 self
        for(SelectionKey key: selector.keys()) {

            Channel targetChannel = key.channel();

            //排除自己
            if(targetChannel instanceof  SocketChannel && targetChannel != self) {
                SocketChannel dest = (SocketChannel)targetChannel;
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                dest.write(buffer);
            }
        }

    }


    public static void main(String[] args) {
        //创建服务器对象
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }

}


