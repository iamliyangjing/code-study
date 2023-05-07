package cn.itast.ssl.server;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2023-04-10 22:37
 **/
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.ssl.SslContext;

import java.nio.charset.Charset;

public class MyServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    private SslContext sslContext;

    public MyServerChannelInitializer(SslContext sslContext) {
        this.sslContext = sslContext;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        // 添加SSL安装验证
        ch.pipeline().addLast(sslContext.newHandler(ch.alloc()));
        ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
        ch.pipeline().addLast(new StringDecoder(Charset.forName("UTF8")));
        ch.pipeline().addLast(new StringEncoder(Charset.forName("UTF8")));
        ch.pipeline().addLast(new MyServerHandler());
    }
}