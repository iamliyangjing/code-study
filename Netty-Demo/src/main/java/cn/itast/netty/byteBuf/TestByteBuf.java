package cn.itast.netty.byteBuf;

import com.sun.org.apache.xpath.internal.operations.String;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import static io.netty.util.internal.StringUtil.NEWLINE;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-13 21:00
 **/
@Slf4j
public class TestByteBuf {
    public static void main(String[] args) {
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer();
        System.out.println(buf.getClass());
        log(buf);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sb.append("a");
        }
        buf.writeBytes(sb.toString().getBytes());
        log(buf);
    }

    public static void log(ByteBuf buffer){
        int length = buffer.readableBytes();
        int rows = length/16 +(length % 15 ==0 ?0:1)+4;
        StringBuilder buf = new StringBuilder(rows*80*2)
                .append("read index:").append(buffer.readerIndex())
                .append("write index:").append(buffer.writerIndex())
                .append("capacity :").append(buffer.capacity())
                .append(NEWLINE);
    }
}
