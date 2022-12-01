package cn.itast.netty.NIO;

import java.nio.ByteBuffer;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-03 23:29
 **/
public class TestByteBufferAllocate {
    public static void main(String[] args) {
        System.out.println(ByteBuffer.allocate(16).getClass());
        System.out.println(ByteBuffer.allocateDirect(16).getClass());

        /**
         * class java.nio.HeapByteBuffer java堆内存 读写效率较低，受到GC
         * class java.nio.DirectByteBuffer 直接内存，读写效率高（少一次拷贝）
         */
    }
}
