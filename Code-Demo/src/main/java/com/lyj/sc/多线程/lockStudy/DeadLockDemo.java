package com.lyj.sc.多线程.lockStudy;

import java.util.concurrent.TimeUnit;

/**
 * @Author: liyangjing
 * @Date: 2022/08/11/22:49
 * @Description:
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        final Object objectA = new Object();
        final Object objectB = new Object();

        new Thread(()->{
            synchronized (objectA){
                System.out.println(Thread.currentThread().getName()+"\t 自己持有A锁，希望获取B锁");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objectB){
                    System.out.println(Thread.currentThread().getName()+"\t 成功获取B锁");
                }
            }
        },"A").start();

        new Thread(()->{
            synchronized (objectB){
                System.out.println(Thread.currentThread().getName()+"\t 自己持有b锁，希望获取a锁");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objectA){
                    System.out.println(Thread.currentThread().getName()+"\t 成功获取a锁");
                }
            }
        },"B").start();
    }
}
