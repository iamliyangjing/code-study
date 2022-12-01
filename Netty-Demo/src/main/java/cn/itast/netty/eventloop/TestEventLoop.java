package cn.itast.netty.eventloop;

import io.netty.channel.DefaultEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.NettyRuntime;

import java.util.concurrent.TimeUnit;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-24 15:14
 **/

public class TestEventLoop {
    public static void main(String[] args) {
        // 1. 创建事件循环组
        NioEventLoopGroup gruop = new NioEventLoopGroup(2);
//        DefaultEventLoop gruop = new DefaultEventLoop();
        // 2. 获取下一个事件循环对象
        System.out.println(gruop.next());
        System.out.println(gruop.next());
        System.out.println(gruop.next());

        //3.执行普通任务
        gruop.next().submit(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("11231");
        });
        //4.定时任务 心跳机制
        /**
         * 1. 初始执行时间
         * 2. 延时时间
         * 3. 延时单位
         */
        gruop.next().scheduleAtFixedRate(()->{
            System.out.println("1");
        },0,1, TimeUnit.SECONDS);
    }
}
