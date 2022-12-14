package cn.itast.netty.c1;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-24 14:38
 **/
public class HelloClient {
    public static void main(String[] args) throws InterruptedException {
        // 1.启动类
        new Bootstrap()
        //2.添加EventLoop
                .group(new NioEventLoopGroup())
                    //3.选择客户端的 channel实现
                .channel(NioSocketChannel.class)
                //4.添加处理器
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override  // 在连接建立后被调用
                    protected void initChannel(NioSocketChannel channel) throws Exception {
                        channel.pipeline().addLast(new StringEncoder());
                    }
                })
                .connect(new InetSocketAddress("localhost",8080))
                //阻塞方法，直到连接建立
                .sync()
                .channel() //代表连接对象
                //6. 向服务器发送数据
                .writeAndFlush("hello world");
    }
}
