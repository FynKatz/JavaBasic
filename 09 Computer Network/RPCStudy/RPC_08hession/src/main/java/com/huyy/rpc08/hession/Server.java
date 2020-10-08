package com.huyy.rpc08.hession;

import com.caucho.hessian.io.Hessian2Input;

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
        ServerSocket ss = new ServerSocket(8888);
        while (running) {
            Socket accept = ss.accept();
            process(accept);
            accept.close();
        }
        ss.close();
    }

    private static void process(Socket s) throws Exception {

        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        Hessian2Input h2i = new Hessian2Input(in);
        //输出流更改为ObjectOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(out);

        //2.读取客户端消息（不变）
        String className = h2i.readString();
        String methodName = h2i.readString();
        Class[] parameterTypes = (Class[]) h2i.readObject();
        Object[] args = (Object[])h2i.readObject();

        //3.（通过反射）调用service中的方法（不变）
//        UserService service = new UserServiceImpl();
        Class clazz = null;
        clazz = UserServiceImpl.class;//假设这里可以通过spring注入类名,或者判断
        Method method = clazz.getMethod(methodName, parameterTypes);//反射
        Object o = method.invoke(clazz.newInstance(), args);

        oos.writeObject(o);
        oos.flush();
    }
}
