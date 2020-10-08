package com.huyy.netty.rpc.dubbo.provider;


import com.huyy.netty.rpc.dubbo.netty.NettyServer;

//ServerBootstrap 会启动一个服务提供者，就是 NettyServer
public class ServerBootstrap {
    public static void main(String[] args) {

        //启动netty
        NettyServer.startServer("127.0.0.1", 7000);
    }
}
