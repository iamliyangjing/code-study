package cn.itast.netty.c4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-06 22:26
 **/
public class WriteClient {
    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost",8080));

        // 3.接受数据
        int count=0;
        while (true){
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            count+=sc.read(buffer);
            System.out.println(count);
            buffer.clear();
        }
    }
}
