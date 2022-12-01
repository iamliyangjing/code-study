package com.lyj.sc.多线程.interrput;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: liyangjing
 * @Date: 2022/08/13/15:14
 * @Description:
 */
public class ConditionLockDemo {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(()->{
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName()+"\t"+"唤醒t1");
            }finally {
                lock.unlock();
            }
        },"t2").start();


        new Thread(()->{
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"\t"+"---come in");
                condition.await();
                System.out.println(Thread.currentThread().getName()+"\t"+"----被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"t1").start();

    }
}
