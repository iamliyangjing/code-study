package com.lyj.sc.多线程;

import java.util.concurrent.*;

/**
 * @Author: liyangjing
 * @Date: 2022/07/23/16:57
 * @Description:
 */
public class CompletableFutureAPI3Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1号任务" + "\t" + Thread.currentThread().getName());
            return "abcd";
        },threadPool).thenRunAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("2号任务" + "\t" + Thread.currentThread().getName());
        }).thenRun(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("3号任务" + "\t" + Thread.currentThread().getName());
        }).thenRun(() -> {
            System.out.println("4号任务" + "\t" + Thread.currentThread().getName());
        });
        System.out.println(completableFuture.get(2L,TimeUnit.SECONDS));
        threadPool.shutdown();
    }
}
