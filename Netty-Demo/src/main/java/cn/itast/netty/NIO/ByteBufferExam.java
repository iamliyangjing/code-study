package cn.itast.netty.NIO;

import java.nio.ByteBuffer;

import static cn.itast.netty.NIO.ByteBufferUtil.debugAll;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-04 09:13
 **/
public class ByteBufferExam {

    public static void main(String[] args) {
        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("hello,world,\niam zhangsan\nHo".getBytes());
        split(source);
        source.put("w are you\n".getBytes());
    }

    public static void split(ByteBuffer source) {
        source.flip();
        for (int i = 0; i < source.limit(); i++) {
            //找到完整的消息
            if(source.get(i)=='\n'){
                int len = i+1-source.position();
                ByteBuffer target = ByteBuffer.allocate(16);
                for (int i1 = 0; i1 < len; i1++) {
                    target.put(source.get());
                }
                debugAll(target);
            }
        }
        source.compact();
    }
}
