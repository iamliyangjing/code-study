package cn.itast.netty.pipeline;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-11 20:30
 **/
@Slf4j
public class TestPipeline {
    public static void main(String[] args) {
        new ServerBootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        // 1.通过channel 拿到pipeline
                        ChannelPipeline pipeline = ch.pipeline();
                        // 2.添加处理器 head-> h1 -> h2 -> h3 -> h4 -> h5 -> h6 ->tail
                        // 双向链表
                        pipeline.addLast("h1",new ChannelInboundHandlerAdapter(){
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                log.debug("1");
                                ByteBuf buf = (ByteBuf)msg;
                                String name = buf.toString(Charset.defaultCharset());
                                // 传递给下一个handler
                                super.channelRead(ctx, name);
                            }
                        });
                        pipeline.addLast("h2",new ChannelInboundHandlerAdapter(){
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                log.debug("2");
                                Student student = new Student(msg.toString());
                                super.channelRead(ctx, student);
                            }
                        });
                        pipeline.addLast("h3",new ChannelInboundHandlerAdapter(){
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                log.debug("3,结果{},class:{}",msg,msg.getClass());
//                                super.channelRead(ctx, msg);
                                ctx.writeAndFlush(ctx.alloc().buffer().writeBytes(("server..").getBytes()));
                                //ch.writeAndFlush(ctx.alloc().buffer().writeBytes(("server..").getBytes()));
                            }
                        });
                        //出栈 从尾部向前
                        pipeline.addLast("h4", new ChannelOutboundHandlerAdapter() {
                            @Override
                            public void write(ChannelHandlerContext channelHandlerContext, Object o, ChannelPromise channelPromise) throws Exception {
                                log.debug("4");
                                super.write(channelHandlerContext,o,channelPromise);
                            }
                        });
                        pipeline.addLast("h5", new ChannelOutboundHandlerAdapter() {
                            @Override
                            public void write(ChannelHandlerContext channelHandlerContext, Object o, ChannelPromise channelPromise) throws Exception {
                                log.debug("5");
                                super.write(channelHandlerContext,o,channelPromise);
                            }
                        });
                        pipeline.addLast("h6", new ChannelOutboundHandlerAdapter() {
                            @Override
                            public void write(ChannelHandlerContext channelHandlerContext, Object o, ChannelPromise channelPromise) throws Exception {
                                log.debug("6");
                                super.write(channelHandlerContext,o,channelPromise);
                            }
                        });
                    }
                }).bind(8080);
    }
    @AllArgsConstructor
    @Data
    static class Student{
        private String name;
    }
}
