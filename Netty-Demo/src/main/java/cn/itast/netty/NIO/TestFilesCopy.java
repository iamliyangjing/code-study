package cn.itast.netty.NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-04 14:43
 **/
public class TestFilesCopy {

    public static void main(String[] args) throws IOException {
        String source ="D:\\snap";
        String target = "D:\\Snipaste-16.2";

        Files.walk(Paths.get(source)).forEach(path->{
            String targetName = path.toString().replace(source,target);

            //是目录
            if(Files.isDirectory(path)){
                try {
                    Files.createDirectory(Paths.get(targetName));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else if(Files.isRegularFile(path)){
                try {
                    Files.copy(path,Paths.get(targetName));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
