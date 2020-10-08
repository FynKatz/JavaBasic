package com.huyy.rpc01;

import com.huyy.rpc.common.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        /* 1.向服务器发送数据 */
        //创建和服务器端口的连接
        Socket socket = new Socket("127.0.0.1", 8888);
        //创建output流，写出id
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(123);//写入id = 123
        //写入id到socket套接字的output流
        socket.getOutputStream().write(baos.toByteArray());
        socket.getOutputStream().flush();

        /* 2.接收服务器端数据 */
        //一直阻塞，等待数据
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        //通过类型，读取类User的对象
        int id = dis.readInt();
        String name = dis.readUTF();
        //创建本地对象
        User user = new User(id, name);
        System.out.println(user);

        dos.close();
        socket.close();
    }
}
