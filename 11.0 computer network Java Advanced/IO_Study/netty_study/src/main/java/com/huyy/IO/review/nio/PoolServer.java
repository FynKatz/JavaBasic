package com.huyy.IO.review.nio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolServer {

    //定义一个线程池（50个工人）
    ExecutorService pool = Executors.newFixedThreadPool(50);

    private Selector selector;
    //中文测试

    /**
     *
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        PoolServer server = new PoolServer();
        server.initServer(8000);//bind+listen
        server.listen();//处理
    }

    /**
     *
     * @param port
     * @throws IOException
     */
    public void initServer(int port) throws IOException {

        ServerSocketChannel serverChannel = ServerSocketChannel.open();//NIO封装类
        serverChannel.configureBlocking(false);//非阻塞
        serverChannel.socket().bind(new InetSocketAddress(port));//绑定bind
        this.selector = Selector.open();//开启selector

        ///注册监听客户端连接事件
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);//监听listen
        System.out.println("服务端启动成功！");
    }

    /**
     *
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public void listen() throws IOException {
        // 轮询访问selector  
        while (true) {
            //
            selector.select();
            //
            Iterator ite = this.selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = (SelectionKey) ite.next();
                //
                ite.remove();
                //如果可连接状态，注册可读状态
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    //
                    SocketChannel channel = server.accept();
                    //
                    channel.configureBlocking(false);
                    //
                    channel.register(this.selector, SelectionKey.OP_READ);
                    //
                } else if (key.isReadable()) {//如果可读状态，交给线程池
                    //
                    key.interestOps(key.interestOps()&(~SelectionKey.OP_READ));
                    //
                    pool.execute(new ThreadHandlerChannel(key));
                }
            }
        }
    }
}

/**
 *
 * @param
 * @throws IOException
 */
class ThreadHandlerChannel extends Thread{
    private SelectionKey key;
    ThreadHandlerChannel(SelectionKey key){
        this.key=key;
    }
    @Override
    public void run() {
        //
        SocketChannel channel = (SocketChannel) key.channel();
        //
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            int size = 0;
            while ((size = channel.read(buffer)) > 0) {
                buffer.flip();
                baos.write(buffer.array(),0,size);
                buffer.clear();
            }
            baos.close();
            //
            byte[] content=baos.toByteArray();
            ByteBuffer writeBuf = ByteBuffer.allocate(content.length);
            writeBuf.put(content);
            writeBuf.flip();
            channel.write(writeBuf);//
            if(size==-1){

                channel.close();
            }else{
                //
                key.interestOps(key.interestOps()|SelectionKey.OP_READ);
                key.selector().wakeup();
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
