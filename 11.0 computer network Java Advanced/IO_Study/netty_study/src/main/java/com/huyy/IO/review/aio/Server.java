package com.huyy.IO.review.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/*
* AIO 单线程
* */
public class Server {
    public static void main(String[] args) throws Exception {

        final AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open()
                .bind(new InetSocketAddress(8888));//AsynchronousServerSocketChannel是AIO封装的类

                                      //观察者模式
        //accept()是异步的（回调函数）。new CompletionHandler接口的实现类，处理过程交给系统，处理完交回给serverChannel
        serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            //completed是已经连接上来。
            @Override
            public void completed(AsynchronousSocketChannel client, Object attachment) {
                serverChannel.accept(null, this);
                try {
                    System.out.println(client.getRemoteAddress());
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    client.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            attachment.flip();
                            System.out.println(new String(attachment.array(), 0, result));
                            client.write(ByteBuffer.wrap("HelloClient".getBytes()));
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            exc.printStackTrace();
                        }
                    });


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //failed是连接出错。
            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
            }
        });

        //保持程序运行（守护）
        while (true) {
            Thread.sleep(1000);
        }
    }
}
