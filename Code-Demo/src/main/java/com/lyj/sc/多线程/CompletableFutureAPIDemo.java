package com.lyj.sc.多线程;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: liyangjing
 * @Date: 2022/07/23/16:43
 * @Description:
 */
public class CompletableFutureAPIDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            //暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });
        TimeUnit.SECONDS.sleep(2);
        System.out.println(completableFuture.getNow("123"));
        System.out.println(completableFuture.complete("completeValue"+"\t"+completableFuture.join()));
    }
}
