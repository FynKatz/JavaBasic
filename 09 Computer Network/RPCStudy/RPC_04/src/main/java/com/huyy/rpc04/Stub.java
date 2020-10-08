package com.huyy.rpc04;

import com.huyy.rpc.common.User;
import com.huyy.rpc.common.UserService;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Stub {
    public static UserService getStub() {
        InvocationHandler h = new InvocationHandler() {
//            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //1. 创建socket
                Socket s = new Socket("127.0.0.1", 8888);

                //2.1 创建socket的output流
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                //2.2 将方法名和参数写出到output流中
                String methodName = method.getName();
                Class[] parametersTypes = method.getParameterTypes();
                oos.writeUTF(methodName);
                oos.writeObject(parametersTypes);
                oos.writeObject(args);
                oos.flush();//刷新，即发送出去

                //3.1 接收服务器端的消息
                DataInputStream dis = new DataInputStream(s.getInputStream());
                //3.2 创建User对象
                int id = dis.readInt();
                String name = dis.readUTF();
                User user = new User(id, name);

                oos.close();
                s.close();
                return user;
            }
        };
        Object o = Proxy.newProxyInstance(
                UserService.class.getClassLoader(), new Class[] {UserService.class}, h);
        return (UserService)o;
    }
}
