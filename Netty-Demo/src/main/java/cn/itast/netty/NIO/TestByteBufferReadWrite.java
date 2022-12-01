package cn.itast.netty.NIO;

import java.nio.ByteBuffer;

import static cn.itast.netty.NIO.ByteBufferUtil.debugAll;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-29 00:33
 **/

public class TestByteBufferReadWrite {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put((byte) 0x61); //'a'
        debugAll(byteBuffer);
        byteBuffer.put(new byte[]{0x62,0x63,0x64});
        debugAll(byteBuffer);
        byteBuffer.flip();
        System.out.println(byteBuffer.get());
        debugAll(byteBuffer);
        System.out.println(byteBuffer.get());
        debugAll(byteBuffer);
        byteBuffer.compact();
        debugAll(byteBuffer);
        byteBuffer.put((byte) 0x69);
        debugAll(byteBuffer);
    }
}
