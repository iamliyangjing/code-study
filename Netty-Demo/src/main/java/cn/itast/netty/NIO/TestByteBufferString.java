package cn.itast.netty.NIO;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import static cn.itast.netty.NIO.ByteBufferUtil.debugAll;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-03 23:40
 **/
public class TestByteBufferString {
    public static void main(String[] args) {
        // 1.字符串转为 ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put("hello".getBytes());
        debugAll(buffer);

        // 2.charset
        ByteBuffer buffer1 = StandardCharsets.UTF_8.encode("hello");
        debugAll(buffer1);
    }
}
