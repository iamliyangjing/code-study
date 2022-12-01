package cn.itast.netty.NIO;

import java.nio.ByteBuffer;

import static cn.itast.netty.NIO.ByteBufferUtil.debugAll;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-03 23:35
 **/
public class TestByteBufferRead {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a','b','c','d'});
        buffer.flip();

        buffer.get(new byte[4]);
        debugAll(buffer);
        buffer.rewind();
    }
}
