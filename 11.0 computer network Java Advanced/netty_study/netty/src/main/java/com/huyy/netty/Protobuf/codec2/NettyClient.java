package com.huyy.netty.Protobuf.codec2;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

public class NettyClient {
    public static void main(String[] args) throws Exception {

        //1. 创建客户端的事件循环组group
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            //2. 创建客户端的启动对象，配置参数
            Bootstrap bootstrap = new Bootstrap();


            //3. 使用链式编程来进行设置
            bootstrap.group(group) //设置一个线程组group
                    .channel(NioSocketChannel.class) // 设置客户端通道的实现类
                    .handler(new ChannelInitializer<SocketChannel>() {//设置处理器
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();

                            //添加Protobuf的编码器
                            pipeline.addLast("encoder",new ProtobufEncoder());

                            pipeline.addLast(new NettyClientHandler()); //添加自定义的handler
                        }
                    });

            System.out.println("客户端 ready...");

            //4. 连接一个服务器的IP和端口, 生成了一个 ChannelFuture 对象【连接就启动客户端】
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6668).sync();

            //5. 对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();

        }finally {
            //6. 最后优雅地关闭group
            group.shutdownGracefully();

        }
    }
}
