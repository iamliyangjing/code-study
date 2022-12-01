package cn.itast.netty.进阶.预设长度;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-25 00:29
 **/
public class TestLengthFieldDecoder {
    public static void main(String[] args) {
        EmbeddedChannel channel = new EmbeddedChannel(
                /**
                 * lengthAdjustment 调整字节段
                 */
                new LengthFieldBasedFrameDecoder(1024,0,4,1,4),
                new LoggingHandler(LogLevel.DEBUG)
        );

        // 4个字节的内容长度，实际内容
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer();
        send(buffer,"hello, world");
        send(buffer,"Hi!");
        channel.writeInbound(buffer);
    }

    public static void send(ByteBuf buffer,String content){
        byte[] bytes = content.getBytes();
        int len = bytes.length;
        buffer.writeInt(len);
        //消息 版本号
        buffer.writeByte(1);
        buffer.writeBytes(bytes);
    }
}
