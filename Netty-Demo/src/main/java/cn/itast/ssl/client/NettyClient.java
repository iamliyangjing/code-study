package cn.itast.ssl.client;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2023-04-10 22:36
 **/
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;

import javax.net.ssl.SSLException;
import java.io.File;

public class NettyClient {
    public static void main(String[] args) throws SSLException{
        new NettyClient().connect("127.0.0.1",6000);
    }

    private void connect(String address, int port) throws SSLException {
        //引入SSL安全验证
        File certChainFile=new File("D:\\ideacode\\Study-Demo\\code-study\\Netty-Demo\\src" +
                "\\main\\java\\cn\\itast\\ssl\\ssl" +
                "\\client\\client.crt");
        File keyFile=new File("D:\\ideacode\\Study-Demo\\code-study\\Netty-Demo\\src" +
                "\\main\\java\\cn\\itast\\ssl" +
                "\\ssl\\client\\pkcs8_client.key");
        File rootFile=new File("D:\\ideacode\\Study-Demo\\code-study\\Netty-Demo" +
                "\\src\\main\\java\\cn\\itast\\ssl" +
                "\\ssl\\client\\ca.crt");
        SslContext sslContext= SslContextBuilder.forClient()
                .keyManager(certChainFile,keyFile)
                .trustManager(rootFile)
                .build();



        EventLoopGroup workGroup=new NioEventLoopGroup();
        try {
            Bootstrap bootstrap=new Bootstrap();
            bootstrap.group(workGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.AUTO_READ,true)
                    .handler(new MyClientChannelInitializer(sslContext));
            ChannelFuture future=bootstrap.connect(address,port).sync();
            System.out.println("netty client start done ....");
            future.channel().closeFuture().sync();
        }catch (Exception e){
            System.out.println("netty client start error ....");
        }finally {
            workGroup.shutdownGracefully();
        }



    }
}