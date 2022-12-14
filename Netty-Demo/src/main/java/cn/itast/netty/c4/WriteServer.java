package cn.itast.netty.c4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-06 22:21
 **/
public class WriteServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.bind(new InetSocketAddress(8080));
        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            selector.select();
            Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
            while (iter.hasNext()){
                SelectionKey key = iter.next();
                iter.remove();;
                if(key.isAcceptable()){
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);

                    SelectionKey sckey = sc.register(selector, 0, null);
                    sckey.interestOps(SelectionKey.OP_READ);
                    //1.向客户端发送大量数据
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 30000000; i++) {
                        sb.append("a");
                    }
                    ByteBuffer buffer = Charset.defaultCharset().encode(sb.toString());
                    //
                        //2.返回值实际写入的字节数
                        int write = sc.write(buffer);
                        System.out.println(write);
                    //3.判断是否有剩余内容
                    if(buffer.hasRemaining()){
                        //4.关注可写事件
                        sckey.interestOps(sckey.interestOps()+SelectionKey.OP_WRITE);
                        //5.把未写完的数据挂到sckey上
                        sckey.attach(buffer);
                    } }
                else if (key.isWritable()) {
                        ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        int write = socketChannel.write(byteBuffer);
                    System.out.println(write);
                    //6.清理操作
                    if(!byteBuffer.hasRemaining()){
                        //需要清除buffer
                        key.attach(null);
                        //不需要关注可写事件
                        key.interestOps(key.interestOps()-SelectionKey.OP_WRITE);
                    }
                }
            }
        }
    }
}
