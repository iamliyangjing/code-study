package cn.itast.netty.channel;

import io.netty.channel.EventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-11 20:08
 **/
@Slf4j
public class TestNettyFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        EventLoop eventLoop = group.next();
        Future<Integer> future = eventLoop.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                log.debug("执行计算！");
                Thread.sleep(1000);
                return 70;
            }
        });
//        log.debug("结果是：{}",future.get());
//        log.debug("结果是：{}",future.get());
        future.addListener(new GenericFutureListener<Future<? super Integer>>() {
            @Override
            public void operationComplete(Future<? super Integer> future) throws Exception {
                log.debug("结果是：{}",future.getNow());
            }
        });
    }
}
