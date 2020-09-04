package com.huyy.rpc.hession;


import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.huyy.rpc.common.User;

import java.io.*;

public class HelloHession {

    public static void main(String[] args) throws Exception {
        User user = new User(123, "Alice");
        //测试系列化后长度
        System.out.println("hessianBytes length=" + hessionSerialize(user).length);//44
        System.out.println("jdk length=" + jdkSerialize(user).length);//185
    }

    /*序列化(对象 转 字节数组)*/
    public static byte[] hessionSerialize(Object o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(baos);//包装
        output.writeObject(o);
        output.flush();

        byte[] bytes = baos.toByteArray();
        baos.close();
        output.close();
        return bytes;
    }

    /*反序列化（字节数组 转 对象）*/
    public static Object hessionDeserialize(byte[] bytes) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        Hessian2Input input = new Hessian2Input(bais);
        Object o = input.readObject();
        bais.close();
        input.close();
        return o;
    }

    public static byte[] jdkSerialize(Object o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream output = new ObjectOutputStream(baos);
        output.writeObject(o);
        output.flush();

        byte[] bytes = baos.toByteArray();
        baos.close();
        output.close();
        return bytes;
    }

    public static Object jdkDeserialize(byte[] bytes) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream input = new ObjectInputStream(bais);
        Object o = input.readObject();
        bais.close();
        input.close();
        return o;
    }

}
