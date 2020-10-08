package com.huyy.NIO;


import java.nio.IntBuffer;

public class BasicBuffer {
    public static void main(String[] args) {
        //说明buffer的使用

        //创建可以存放5个int的buffer
        IntBuffer intBuffer = IntBuffer.allocate(5);
        //存数据
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i+5);
        }
        //取数据（需要先读写切换）
        intBuffer.flip();//将buffer读写切换！！！！！！！！
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }
}
