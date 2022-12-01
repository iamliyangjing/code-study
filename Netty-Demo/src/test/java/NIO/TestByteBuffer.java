package NIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-27 23:32
 **/
public class TestByteBuffer {

    public static void main(String[] args) {
            // FileChannel
            // 1.输入输出流  2.RandomAccessFile(随机读写文件的类)
        try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {
            while (true){
                //准备缓冲区
                ByteBuffer buffer = ByteBuffer.allocate(10);
                //从channel里面读取数据，向Buffer写入
                channel.read(buffer);
                //打印Buffer的内容
                buffer.flip();//切换读模式
                while (buffer.hasRemaining()){
                    byte b = buffer.get();
                    System.out.println((char)b);
                }
                buffer.clear();//切换写模式
            }
        } catch (IOException e) {
        }
    }
}
