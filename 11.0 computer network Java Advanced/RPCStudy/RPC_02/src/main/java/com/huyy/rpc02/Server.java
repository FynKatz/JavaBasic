package com.huyy.rpc02;

import com.huyy.rpc.common.User;
import com.huyy.rpc.common.UserService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static boolean running = true;
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);//监听服务端口
        while (running) {
            Socket accept = ss.accept();//接收客户端连接
            process(accept);//对客户端进行处理
            accept.close();
        }
        ss.close();
    }

    /*对客户端进行处理*/
    private static void process(Socket accept) throws IOException {
        //创建IO流
        InputStream in = accept.getInputStream();
        OutputStream out = accept.getOutputStream();
        DataInputStream dis = new DataInputStream(in);
        DataOutputStream dos = new DataOutputStream(out);

        //input先读取id
        int id = dis.readInt();
        //调用service方法生成User对象
        UserService service = new UserServiceImpl();
        User user = service.findUserById(id);
        //写入output
        dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
        dos.flush();
    }
}
