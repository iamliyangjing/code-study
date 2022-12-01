package cn.itast.netty.byteBuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import static io.netty.buffer.ByteBufUtil.appendPrettyHexDump;
import static io.netty.util.internal.StringUtil.NEWLINE;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-13 21:34
 **/
public class TestSlice {
    public static void main(String[] args) {
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer(10);
        buf.writeBytes(new byte[]{'a','b','c','d','e','f','g','h','a','b'});
        log(buf);

        ByteBuf f1 = buf.slice(0, 5);
        //引用计数加一
        f1.retain();
        ByteBuf f2 = buf.slice(5, 5);
        log(f1);
        log(f2);

        System.out.println("释放原有byteBuf");
        buf.release();
        // f1 和f2 都是一块内存 ，原始的释放了，f1也释放了
        f1.release();
        log(f1);
        //Exception in thread "main" java.lang.IndexOutOfBoundsException: writerIndex(5) + minWritableBytes(1) exceeds maxCapacity(5): UnpooledSlicedByteBuf(ridx: 0, widx: 5, cap: 5/5, unwrapped: PooledUnsafeDirectByteBuf(ridx: 0, widx: 10, cap: 10))
        //        f1.writeByte('a');

//        f1.setByte(0,'b');
//        log(f1);
//        log(buf);
    }

    public static void log(ByteBuf buffer) {
        int length = buffer.readableBytes();
        int rows = length / 16 + (length % 15 == 0 ? 0 : 1) + 4;
        StringBuilder buf = new StringBuilder(rows * 80 * 2)
                .append("read index:").append(buffer.readerIndex())
                .append(" write index:").append(buffer.writerIndex())
                .append(" capacity:").append(buffer.capacity())
                .append(NEWLINE);
        appendPrettyHexDump(buf, buffer);
        System.out.println(buf.toString());
    }
}
