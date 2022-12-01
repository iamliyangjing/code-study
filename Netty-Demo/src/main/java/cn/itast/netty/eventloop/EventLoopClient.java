package cn.itast.netty.eventloop;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

/**
 * @program: Study-Demo
 * @description: IO client
 * @author: lyj
 * @create: 2022-09-24 15:25
 **/
@Slf4j
public class EventLoopClient {
    public static void main(String[] args) throws InterruptedException {
        // 2.带有future，Promise 的类型都是和异步方法配套使用，用来处理结果的
        ChannelFuture channelFuture = new Bootstrap()
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
                // 异步非阻塞，main来调用，真正执行connect的是NIO线程
                .connect(new InetSocketAddress("localhost", 8080));
                //阻塞方法，直到连接建立
//                .sync() //阻塞住，等待连接建立。
//                .channel();//代表连接对象
        // 2.1 使用sync 方法同步处理结果
        channelFuture.sync();
        Channel channel = channelFuture.channel();
        log.debug("{}",channel);
        channel.writeAndFlush("hello,world");

        // 2.2 使用addListenner()方法异步处理结果
        System.out.println(channel);
        channelFuture.addListener(new ChannelFutureListener() {
            @Override
            // 在nio 线程连接建立之后，会调用这个 operationComplete
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                //还是nio线程处理
                Channel channel = channelFuture.channel();
                log.debug("{}",channel);
                channel.writeAndFlush("hello,world");
            }
        });
    }
}
