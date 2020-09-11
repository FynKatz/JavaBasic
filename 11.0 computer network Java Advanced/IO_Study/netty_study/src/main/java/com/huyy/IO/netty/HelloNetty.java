package com.huyy.IO.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

/**
 * 启动Netty的服务器端
 */
public class HelloNetty {
    public static void main(String[] args) {
        new NettyServer(8888).serverStart();
    }
}


/**
 * Netty的服务器端
 */
class NettyServer {

    int port = 8888;

    public NettyServer(int port) {
        this.port = port;
    }

    public void serverStart() {
        EventLoopGroup bossGroup = new NioEventLoopGroup();//selector线程池
        EventLoopGroup workerGroup = new NioEventLoopGroup();//worker线程池
        ServerBootstrap b = new ServerBootstrap();//server启动的封装类

        //分别指定boss（只负责连接）和worker（只负责连接后的IO处理），
        // 指定客户端连接上的类型是NioServerSocketChannel,
        //对每个连接上来的客户端做处理handler：
         //一旦通道初始化后，就对这个通道添加处理器。
        b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        //传入的ch，是已经建立起来客户端和selector之间的SocketChannel通道
                        ch.pipeline().addLast(new Handler());//具体的处理过程，下面实现了。
                    }
                });

        try {
            ChannelFuture f = b.bind(port).sync();

            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }


    }
}


/**
 * worker在通道上对数据的处理过程
 */
class Handler extends ChannelInboundHandlerAdapter {

    //不需要接收数据，直接对已经得到的数据进行处理。
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //super.channelRead(ctx, msg);
        System.out.println("server: channel read");
        ByteBuf buf = (ByteBuf)msg;

        System.out.println(buf.toString(CharsetUtil.UTF_8));

        ctx.writeAndFlush(msg);

        ctx.close();

        //buf.release();
    }

    //数据异常的处理 -- close。
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();
    }
}
