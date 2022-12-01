package cn.itast.netty.channel;

import io.netty.channel.EventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.DefaultPromise;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-11 20:21
 **/
@Slf4j
public class TestPromise {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1.准备 EventLoop对象
        EventLoop eventLoop = new NioEventLoopGroup().next();

        // 2.可以主动创建promise，结果容器
        DefaultPromise<Integer> promise = new DefaultPromise<>(eventLoop);

        new Thread(()->{
            // 3.任意一个线程执行计算，计算完毕后向proimise填充结果
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            promise.setSuccess(80);
        }).start();

        // 4.接收结果的线程
        log.debug("等待结果..");
        log.debug("结果是：{}",promise.get());
    }
}
