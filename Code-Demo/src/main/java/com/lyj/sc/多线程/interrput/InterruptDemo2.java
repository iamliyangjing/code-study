package com.lyj.sc.多线程.interrput;

import java.util.concurrent.TimeUnit;

/**
 * @Author: liyangjing
 * @Date: 2022/08/13/12:10
 * @Description:
 */
public class InterruptDemo2 {

    public static void main(String[] args) throws InterruptedException {
        //实例方法interrupt()仅仅时设置线程的中断状态位为ture
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 300; i++) {
                System.out.println("-------" + i);
            }
            System.out.println("t1线程调用interrupt()后 的中断标识02："+Thread.currentThread().isInterrupted());//true
        }, "t1");
        t1.start();

        System.out.println("t1线程调用interrupt()后 的中断标识01："+t1.isInterrupted());//false

        //暂停毫秒

        TimeUnit.MILLISECONDS.sleep(2);

        t1.interrupt();//true
        System.out.println("t1线程调用interrupt()后 的中断标识02："+t1.isInterrupted());//true

        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("t1线程调用interrupt()后 的中断标识02："+t1.isInterrupted());//false 对不活动的线程不会产生任何影响


    }

}
