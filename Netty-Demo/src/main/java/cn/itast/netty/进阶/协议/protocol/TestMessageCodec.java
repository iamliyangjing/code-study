package cn.itast.netty.进阶.协议.protocol;

import cn.itast.netty.进阶.协议.message.LoginRequestMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LoggingHandler;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-27 20:43
 **/
public class TestMessageCodec {
    public static void main(String[] args) throws Exception {
        /**
         * 帧解码器
         */
        EmbeddedChannel channel = new EmbeddedChannel(new LoggingHandler(),
                new LengthFieldBasedFrameDecoder(1024,12,4,0,0),
                new MessageCodec());
        //encode
        LoginRequestMessage message = new LoginRequestMessage("zhangsan", "123", "张三");
//        channel.writeOutbound(message);

        //decode
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();
        new MessageCodec().encode(null,message,buf);

        ByteBuf s1 = buf.slice(0, 100);
        ByteBuf s2 = buf.slice(100, buf.readableBytes() - 100);

        s1.retain();//引用计数 2
        channel.writeInbound(s1);
        //入站
        channel.writeInbound(s2);
    }
}
