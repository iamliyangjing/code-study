package cn.itast.netty.NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-04 09:25
 **/
public class TestFileChannelTransferTo {
    public static void main(String[] args) {
        try(
        FileChannel from = new FileInputStream("D:\\ideacode\\Study-Demo\\Netty-Demo\\words.txt").getChannel();
        FileChannel to =  new FileOutputStream("D:\\ideacode\\Study-Demo\\Netty-Demo\\to.txt").getChannel();
        ) {
            //效率高，底层利用操作系统
            long size = from.size();
            for(long left=size;left>0; ){
                System.out.println("position:"+(size-left)+" left: "+left);
                left-=from.transferTo((size-left),left,to);
            }
            from.transferTo(0,from.size(),to);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
