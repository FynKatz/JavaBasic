package com.huyy.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyServer {

    public static void main(String[] args) throws Exception {

        /*说明
        * 1）. 创建两个线程组 bossGroup 和 workerGroup
        * 2）. bossGroup 只是处理连接请求 , 真正的和客户端业务处理，会交给 workerGroup完成
        * 3）. 两个都是无限循环
        * 4）. bossGroup 和 workerGroup 含有的子线程(NioEventLoop)的个数 = (默认)实际cpu核数 * 2
        * */
        //1. 创建BossGroup 和 WorkerGroup
        EventLoopGroup bossGroup = new NioEventLoopGroup();   //默认是cpu*2,即12
        EventLoopGroup workerGroup = new NioEventLoopGroup(); //默认是cpu*2,即12

        try {
            //2. 创建服务器端的启动对象，配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();

            //3. 使用链式编程来进行设置
            bootstrap.group(bossGroup, workerGroup) //设置两个线程组
                    .channel(NioServerSocketChannel.class) //使用NioSocketChannel 作为服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG, 128) // 设置线程队列得到连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true) //设置保持活动连接状态
                    /* 为 workerGroup 的 EventLoop 对应的管道设置处理器【创建一个通道初始化对象(匿名对象)】*/
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        //给pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyServerHandler());//添加自定义的handler
                        }
                    });

            System.out.println("服务器 ready...");

            //4. 绑定一个端口并且同步, 生成了一个 ChannelFuture 对象【绑定即启动服务器】
            ChannelFuture cf = bootstrap.bind(6668).sync();
            //给cf 注册监听器，监控我们关心的事件
            cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (cf.isSuccess()) {
                        System.out.println("监听端口 6668 成功");
                    } else {
                        System.out.println("监听端口 6668 失败");
                    }
                }
            });

            //5. 对关闭通道进行监听
            cf.channel().closeFuture().sync();

        }finally {
            //6. 最后优雅地关闭 bossGroup 和 workerGroup
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

}
