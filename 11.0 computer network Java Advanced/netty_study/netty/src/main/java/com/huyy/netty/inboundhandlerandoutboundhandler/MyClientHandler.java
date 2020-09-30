package com.huyy.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

public class MyClientHandler  extends SimpleChannelInboundHandler<Long> {

    //读取数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {

        System.out.println("服务器的ip=" + ctx.channel().remoteAddress());
        System.out.println("收到服务器消息=" + msg);

    }

    //发送数据
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println("MyClientHandler 发送数据");
        ctx.writeAndFlush(123456L); //发送的是一个long
//        ctx.writeAndFlush(Unpooled.copiedBuffer("adcdabcdabcdabcd",CharsetUtil.UTF_8));//16字节

    }
}
