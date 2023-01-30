package cn.itast.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-20 11:44
 **/
public class MyClientHandler extends ChannelInboundHandlerAdapter {
    /**
     * 当客户端主动连接服务端的连接后，这个通道就是活跃的了。也就是客户端与服务端建立了通信通道并且可以传输数据
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        SocketChannel channel = (SocketChannel) ctx.channel();
        System.out.println("连接报告开始");
        System.out.println("连接报告channelid"+channel.id());
        System.out.println("连接报告ip："+channel.localAddress().getAddress());
        System.out.println("连接报告port:"+channel.localAddress().getPort());
        System.out.println("连接报告完毕!");
        //通知客户端连接建立成功
        String str = "通知服务端连接建立成功"+""+new Date()+""+channel.localAddress().getHostString()+"\r\n";
        ctx.writeAndFlush(str);
    }

    /**
     * 当客户端主动断开服务端的连接后，这个通道是不活跃的。
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("断开连接"+ctx.channel().localAddress().toString());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //接受msg消息
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+
                "接收到消息："+msg);
        //通知客户端链 消息发送成功
        ctx.writeAndFlush("客户端收到："+new Date()+"\r\n");
    }

    /**
     * 抓住异常，当发生异常的时候，可以做一些相应的处理，比如打印日志，关闭链接
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        System.out.println("异常信息：\r\n"+cause.getMessage());
    }
}
