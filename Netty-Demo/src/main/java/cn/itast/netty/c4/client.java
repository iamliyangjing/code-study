package cn.itast.netty.c4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-04 14:56
 **/
public class client {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8080));
        System.out.println("waiting....");
    }
}
