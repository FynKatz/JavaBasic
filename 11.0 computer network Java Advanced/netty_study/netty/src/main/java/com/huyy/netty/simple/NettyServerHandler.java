package com.huyy.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/*
说明
1. 我们自定义一个Handler 需要继续netty 规定好的某个HandlerAdapter(规范)
2. 这时我们自定义一个Handler , 才能称为一个handler
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    //1. 读取数据(客户端消息)事件时触发
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        /*比如这里我们有一个非常耗时长的业务-> 异步执行 -> 提交该channel 对应的 NIOEventLoop 的 taskQueue中*/
        //解决方案2 : 用户自定义定时任务 -》 该任务是提交到 scheduleTaskQueue中
        ctx.channel().eventLoop().schedule(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(5 * 1000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端~(>^ω^<)喵4", CharsetUtil.UTF_8));
                    System.out.println("channel code=" + ctx.channel().hashCode());
                } catch (Exception ex) {
                    System.out.println("发生异常" + ex.getMessage());
                }
            }
        }, 5, TimeUnit.SECONDS);

        
        /* 说明：
         * 1）. ChannelHandlerContext ctx:上下文对象, 含有（ 管道pipeline , 通道channel, 地址 ）等信息
         * 2）. Object msg: 就是客户端发送的数据 默认Object
         * 3）. 管道pipeline 和 通道channel 就是互相包含的关系（能互查）。
         */
        //将 msg 转成一个 ByteBuf，并打印。
        ByteBuf buf = (ByteBuf) msg;//注意：这里的ByteBuf 是 Netty 提供的，不是 NIO 的 ByteBuffer.
        System.out.println("接收到 客户端消息:" + buf.toString(CharsetUtil.UTF_8));
//        System.out.println("客户端地址:" + ctx.channel().remoteAddress());
    }

    //2. 数据读取完毕时的事件触发
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        //writeAndFlush 是 write + flush
        //将数据写入到缓存，并刷新
        //一般讲，我们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端", CharsetUtil.UTF_8));
    }

    //3. 遇到异常时触发
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();//关闭通道
    }
}
