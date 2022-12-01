package com.lyj.sc.多线程;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author: liyangjing
 * @Date: 2022/07/23/16:57
 * @Description:
 */
public class CompletableFutureFastDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<String> completableFutureA = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "playA";
        });

        CompletableFuture<String> completableFutureB = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "playB";
        });
        System.out.println(completableFutureA.get());
        CompletableFuture<String> result = completableFutureA.applyToEither(completableFutureB, f -> {
            return f + " is winner";
        });

        System.out.println(Thread.currentThread().getName()+"\t"+"------:"+result.join());
    }
}
