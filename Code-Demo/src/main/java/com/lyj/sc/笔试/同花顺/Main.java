package com.lyj.sc.笔试.同花顺;

import java.util.concurrent.CountDownLatch;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-10 16:08
 **/
public class Main {
    public static volatile boolean flag = true;
    public static CountDownLatch countDownLatch = new CountDownLatch(10);
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
                while (flag){
                    System.out.println("i am working！");
                    countDownLatch.countDown();
                }
        });
        thread.setName("work");
        thread.start();
        countDownLatch.await();
        flag=false;
        System.out.println("finished working!");
    }



}
