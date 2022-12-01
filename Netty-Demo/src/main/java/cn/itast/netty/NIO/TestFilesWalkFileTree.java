package cn.itast.netty.NIO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-04 14:27
 **/
public class TestFilesWalkFileTree {
    public static void main(String[] args) throws IOException {
        AtomicInteger dircount = new AtomicInteger();
        AtomicInteger fileCount = new AtomicInteger();
        // 访问者模式
        Files.walkFileTree(Paths.get("D:\\CodeResoure\\黑马\\黑马头条"),new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println(dir);
                dircount.getAndIncrement();
                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                fileCount.getAndIncrement();
                return super.visitFile(file, attrs);
            }
        });
    }
}
