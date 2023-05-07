package cn.itast.ssl.server;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2023-04-10 22:37
 **/
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.ssl.ClientAuth;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.SslContext;

import javax.net.ssl.SSLException;
import java.io.File;

public class NettyServer {

    public static void main(String[] args) throws SSLException{
        new NettyServer().bind(6000);
    }

    private void bind(int port) throws SSLException {
        //引入SSL安全验证
        File certChainFile=new File("D:\\ideacode\\Study-Demo\\" +
                "code-study\\Netty-Demo\\src" +
                "\\main\\java\\cn\\itast\\ssl" +
                "\\ssl\\server\\server.crt");
        File keyFile=new File("D:\\ideacode\\Study-Demo\\" +
                "code-study\\Netty-Demo\\src\\main" +
                "\\java\\cn\\itast\\ssl\\ssl" +
                "\\server\\pkcs8_server.key");
        File rootFile=new File("D:\\ideacode\\Study-Demo\\code-study\\Netty-Demo\\src" +
                "\\main\\java\\cn\\itast\\ssl" +
                "\\ssl\\server\\ca.crt");
        SslContext sslContext= SslContextBuilder
                .forServer(certChainFile,keyFile)
                .trustManager(rootFile)
                .clientAuth(ClientAuth.REQUIRE)
                .build();
        EventLoopGroup parentGroup=new NioEventLoopGroup(1);
        EventLoopGroup childGroup=new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap=new ServerBootstrap();
            bootstrap.group(parentGroup,childGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childHandler(new MyServerChannelInitializer(sslContext));
            ChannelFuture future=bootstrap.bind(port).sync();
            Channel channel = future.channel();
            channel.writeAndFlush("nihao 客户端！");
            System.out.println("netty server start done...");
            future.channel().closeFuture().sync();
        }catch (Exception e){
            System.out.println("netty server start error...");
        }finally {
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }
    }
}