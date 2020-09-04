package com.huyy.rpc02;

import com.huyy.rpc.common.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Stub {

    /*新建代理的方法————实际上就是版本1里面的客户端代码*/
    public User findUserById(Integer id) throws Exception {

        //1.0 创建socket套接字，连接客户端
        Socket s = new Socket("127.0.0.1", 8888);

        //2.1 向output写出id = 123
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(123);
        //2.2 客户端将output的值写出到服务器
        s.getOutputStream().write(baos.toByteArray());
        s.getOutputStream().flush();

        //3.1 客户端接收服务器的消息
        DataInputStream dis = new DataInputStream(s.getInputStream());
        //3.2 将接收的消息new User对象
        int receivedId = dis.readInt();
        String name = dis.readUTF();
        User user = new User(id, name);

        dos.close();
        s.close();
        return user;
    }
}
