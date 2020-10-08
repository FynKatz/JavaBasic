package com.huyy.rpc08.hession;

import com.caucho.hessian.io.Hessian2Output;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Stub {
    public static Object getStub(final Class clazz) {

        InvocationHandler h = new InvocationHandler() {
//            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //1. 创建socket
                Socket s = new Socket("127.0.0.1", 8888);

                //2.1 创建socket的output流（利用Hessian包装）
                Hessian2Output h2o = new Hessian2Output(s.getOutputStream());
                //2.2 将方法名和参数写出到output流中（不变）
                String className = clazz.getName();
                String methodName = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();
                h2o.writeString(className);
                h2o.writeString(methodName);
                h2o.writeObject(parameterTypes);
                h2o.writeObject(args);
                h2o.flush();

                //3.1 接收服务器端的消息(将之前的DataInputStream改为ObjectInputStream，直接接收对象)
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                //3.2 创建User对象（直接从流里获取对象）
                Object o = ois.readObject();

                h2o.close();
                s.close();

                return o;
            }
        };
        return Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},h);
    }
}
