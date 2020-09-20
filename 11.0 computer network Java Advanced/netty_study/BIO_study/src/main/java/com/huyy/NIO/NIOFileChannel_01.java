package com.huyy.NIO;


import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel_01 {

    public static void main(String[] args) throws IOException {

        String str = "hello world";
        //创建一个输出流fileoutpout
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\file01.txt");
        //fileoutpout  --写入-- 》 channel
        FileChannel fileChannel = fileOutputStream.getChannel();
        //创建一个buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //将str放入buffer
        byteBuffer.put(str.getBytes());
        //读写切换
        byteBuffer.flip();
        //把缓冲区的数据写到通道中
        fileChannel.write(byteBuffer);
        //关闭流
        fileOutputStream.close();

    }
}
