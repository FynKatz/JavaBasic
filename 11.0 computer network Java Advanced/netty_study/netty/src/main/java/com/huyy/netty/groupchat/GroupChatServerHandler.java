package com.huyy.netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {

    //0. （全局）定义一个channle 组，管理所有的channel（轮子）
    private static ChannelGroup  channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
                                          //GlobalEventExecutor.INSTANCE) 是全局的事件执行器，是一个单例
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    //1. 连接建立：一旦连接，第一个被执行
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

        Channel channel = ctx.channel();

        //将该客户加入聊天的信息推送给其它在线的客户端
        // （该方法会将 channelGroup 中所有的channel 遍历，并发送 消息，我们不需要自己遍历）
        channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress()
                + " 加入聊天  " + sdf.format(new java.util.Date()) + " \n");

        channelGroup.add(channel);//将当前channel 加入到  channelGroup
    }

    //2. 断开连接：将xx客户离开信息推送给当前在线的客户
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

        Channel channel = ctx.channel();

        //通知
        channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress() + " 离开了\n");

        //另外不需要手动删除，netty自动删除！！！！

    }

    //3. 表示channel 处于活动状态, 提示 xx上线
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        System.out.println(ctx.channel().remoteAddress() + " 上线了~");
    }

    //4. 表示channel 处于不活动状态, 提示 xx离线了
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

        System.out.println(ctx.channel().remoteAddress() + " 离线了~");
    }

    //5. 读取数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

        Channel channel = ctx.channel();

        //接收客户端发送来的消息，再转发到不同的客户端（这时我们遍历channelGroup, 根据不同的情况，回送不同的消息）
        channelGroup.forEach(ch -> {
            if(channel != ch) { //不是当前的channel,转发消息
                ch.writeAndFlush("[客户端]" + channel.remoteAddress() + " 发送消息：" + msg + "\n");
            }else {//回显自己发送的消息给自己
                ch.writeAndFlush("[自己]发送消息：" + msg + "\n");
            }
        });
    }

    //6. 异常处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //关闭通道
        ctx.close();
    }
}
