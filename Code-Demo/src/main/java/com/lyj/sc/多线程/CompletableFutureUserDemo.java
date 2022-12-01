package com.lyj.sc.多线程;

import java.util.concurrent.*;

/**
 * @Author: liyangjing
 * @Date: 2022/07/23/11:03
 * @Description:
 */
public class CompletableFutureUserDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            CompletableFuture.supplyAsync(()->{
                System.out.println(Thread.currentThread().getName() + "---- come in");
                int result = ThreadLocalRandom.current().nextInt(10);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("----- 1秒钟后出结果" + result);
                if(result>2){
                    int i = 10/0;
                }
                return result;
                //v：上一步的值  e ：触发的异常
            },executorService).whenComplete((v,e)->{
                if(e==null){
                    //为什么没有打印 出这句话
                    //因为main线程结束了 我们的completable的默认线程池forkjoin相当于守护线程
                    System.out.println("---计算完成，更新系统updateVa:"+v);
                }
            }).exceptionally(e->{
                e.printStackTrace();
                System.out.println("异常情况："+e.getCause()+"\t"+e.getMessage());
                return null;
            });
            System.out.println(Thread.currentThread().getName()+"先去忙其他任务");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }


//        CompletableFuture.supplyAsync(()->{
//            System.out.println(Thread.currentThread().getName() + "---- come in");
//            int result = ThreadLocalRandom.current().nextInt(10);
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("----- 1秒钟后出结果" + result);
//            return result;
//            //v：上一步的值  e ：触发的异常
//        }).whenComplete((v,e)->{
//            if(e==null){
//                //为什么没有打印 出这句话
//                //因为main线程结束了 我们的completable的默认线程池forkjoin相当于守护线程
//                System.out.println("---计算完成，更新系统updateVa:"+v);
//            }
//        }).exceptionally(e->{
//            e.printStackTrace();
//            System.out.println("异常情况："+e.getCause()+"\t"+e.getMessage());
//            return null;
//        });
//
//        System.out.println(Thread.currentThread().getName()+"先去忙其他任务");
//        //主线程不要立刻结束，否则completablefuture默认使用的线程池会立刻关闭“暂停3秒钟线程
//        TimeUnit.SECONDS.sleep(3);
    }


    private static void future1() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "---- come in");
            int result = ThreadLocalRandom.current().nextInt(10);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----- 1秒钟后出结果" + result);
            return result;
        });
        System.out.println(Thread.currentThread().getName()+"线程先去忙其他任务了");
        System.out.println(completableFuture.get());
    }


}
