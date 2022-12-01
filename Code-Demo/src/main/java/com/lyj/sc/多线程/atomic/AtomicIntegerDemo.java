package com.lyj.sc.多线程.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-08-20 14:21
 **/

class MyNumber{
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addPlusPlus(){
        atomicInteger.getAndIncrement();
    }
}

public class AtomicIntegerDemo {

    public static final int SIZE=50;

    public static void main(String[] args) throws InterruptedException {
        MyNumber myNumber = new MyNumber();
        //使用CountDownLatch
        CountDownLatch countDownLatch = new CountDownLatch(SIZE);
        for (int i = 1; i <=SIZE; i++) {
            new Thread(()->{
                try {
                    for (int j=1;j<=1000;j++){
                        myNumber.addPlusPlus();
                    }
                }finally {
                    //--1
                    countDownLatch.countDown();
                }
            },String.valueOf(i)).start();
        }
        //等待上面50个线程全部计算完成后，再去获取最终值

        //暂停几秒钟线程
        // TimeUnit.SECONDS.sleep(2);
        // 等待countdownlatch为0
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+myNumber.atomicInteger.get());
    }
}
