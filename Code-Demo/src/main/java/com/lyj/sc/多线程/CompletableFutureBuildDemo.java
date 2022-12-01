package com.lyj.sc.多线程;

import java.util.concurrent.*;

/**
 * @Author: liyangjing
 * @Date: 2022/07/23/10:20
 * @Description:
 */
public class CompletableFutureBuildDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
//
//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//            System.out.println(Thread.currentThread().getName());
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        },threadPool);
//        System.out.println(future.get());
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello world";
        },threadPool);
        System.out.println(completableFuture.get());

        threadPool.shutdown();;
    }
}
