package cn.itast.netty.channel;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-11 20:03
 **/
@Slf4j
public class TestJdkFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1.线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // 2.提交任务
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("计算");
                Thread.sleep(1000);
                return 50;
            }
        });
        //3.主线程通过future对象来获取结果
        log.debug("结果是：{}",future.get());
        log.debug("结果是：{}",future.get());
    }
}
