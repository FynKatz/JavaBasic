package com.huyy.rpc06;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static boolean running = true;
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8888);//监听端口
        while (running) {
            Socket s = ss.accept();//1.等待服务端消息，有消息执行下步
            process(s);
            s.close();
        }
        ss.close();
    }

    private static void process(Socket s) throws Exception {

        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        ObjectInputStream ois = new ObjectInputStream(in);
        //输出流更改为ObjectOutputStream
        ObjectOutputStream dos = new ObjectOutputStream(out);

        //2.读取客户端消息（不变）
        String clazzName = ois.readUTF();
        String methodName = ois.readUTF();
        Class[] parameterTypes = (Class[])ois.readObject();
        Object[] args = (Object[])ois.readObject();

        //3.（通过反射）调用service中的方法（不变）
//        UserService service = new UserServiceImpl();
        Class clazz = null;
        clazz = UserServiceImpl.class;//假设这里可以通过spring注入类名,或者判断
        Method method = clazz.getMethod(methodName, parameterTypes);//反射
        Object o = method.invoke(clazz.newInstance(), args);

        dos.writeObject(o);//输出流写出对象
        dos.flush();
    }
}
