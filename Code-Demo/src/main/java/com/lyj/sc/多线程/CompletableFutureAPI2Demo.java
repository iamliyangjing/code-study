package com.lyj.sc.多线程;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: liyangjing
 * @Date: 2022/07/23/16:57
 * @Description:
 */
public class CompletableFutureAPI2Demo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletableFuture.supplyAsync(()->{
            try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();};
            System.out.println("111");
            return 1;
        },executorService).thenApply(f->{
            System.out.println("222");
            return f+2;
        }).thenApply(f->{
            System.out.println("333");
            return f+3;
        }).whenComplete((v,e)->{
            if(e==null){
                System.out.println("----计算结果:  "+v);
            }
        }).exceptionally(e->{
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        });
        System.out.println(Thread.currentThread().getName()+"---主线程是我！");
        executorService.shutdown();
    }
}
