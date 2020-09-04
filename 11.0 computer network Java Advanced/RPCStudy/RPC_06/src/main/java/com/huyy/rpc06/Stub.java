package com.huyy.rpc06;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Stub {

    //返回类型改为Object类型，具体执行的service类型会通过参数传入
    public static Object getStub(final Class clazz) {//传入Class类型

        InvocationHandler h = new InvocationHandler() {
//            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //1. 创建socket
                Socket s = new Socket("127.0.0.1", 8888);

                //2.1 创建socket的output流（不变）
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                //2.2 将方法名和参数写出到output流中（不变）
                String clazzName = clazz.getName();//Class类名
                String methodName = method.getName();
                Class[] parametersTypes = method.getParameterTypes();
                oos.writeUTF(clazzName);//写出class类名
                oos.writeUTF(methodName);
                oos.writeObject(parametersTypes);
                oos.writeObject(args);
                oos.flush();//刷新，即发送出去

                //3.1 接收服务器端的消息(将之前的DataInputStream改为ObjectInputStream，直接接收对象)
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                //3.2 创建User对象（直接从流里获取对象）
                Object object = ois.readObject();//直接读取对象

                oos.close();
                s.close();
                return object;
            }
        };
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(),new Class[] {clazz}, h);
        return o;
    }
}
