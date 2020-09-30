package com.huyy.NIO;

import java.nio.ByteBuffer;

public class ReadOnlyBuffer {
    public static void main(String[] args) {

        //创建一个buffer
        ByteBuffer buffer = ByteBuffer.allocate(64);
        buffer.put("hello".getBytes());
        //读写反转
        buffer.flip();
        //得到一个只读的Buffer
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        //报错
        readOnlyBuffer.put((byte)100); //ReadOnlyBufferException
    }
}
