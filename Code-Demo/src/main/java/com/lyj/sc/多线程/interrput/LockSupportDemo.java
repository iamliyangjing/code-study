package com.lyj.sc.多线程.interrput;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: liyangjing
 * @Date: 2022/08/13/14:59
 * @Description:
 */
public class LockSupportDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "---come in");
            LockSupport.park();
            LockSupport.park();
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" + "----被唤醒");
        }, "t1");
        t1.start();

        //暂停几秒钟
        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            LockSupport.unpark(t1);
            LockSupport.unpark(t1);
            LockSupport.unpark(t1);
            LockSupport.unpark(t1);
            System.out.println(Thread.currentThread().getName()+"\t"+"----unpark over");
        },"t2").start();

    }
}
