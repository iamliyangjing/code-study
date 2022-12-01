package cn.itast.netty.c1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-24 13:14
 **/
public class HelloServer {

    public static void main(String[] args) {
        // 1. 启动器，负责组装，netty组件，启动服务器
        new ServerBootstrap()
                // 2. BossEventLoop,WorkerEventLoop（selector,thread）
                .group(new NioEventLoopGroup())
                // 3. 选服务器的serverSocketChannel实现
                .channel(NioServerSocketChannel.class)
                // 4. boss 负责处理链接worler(child） 负责处理读写 决定了worker做什么
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                        // 5. channel 代表和客户点进行数据读写的通过
                    @Override
                    protected void initChannel(NioSocketChannel channel) throws Exception {
                        // 6.添加具体的handler
                        channel.pipeline().addLast(new StringDecoder()); // 将转送过来的bytebuf转换
                        channel.pipeline().addLast(new ChannelInboundHandlerAdapter(){ // 自定义handler
                            // 读事件
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                // 打印上一步转换好的字符串
                                System.out.println(msg);
                            }
                         });
                    }
                    //7.绑定监听端口
                }).bind(8080);
    }
}
