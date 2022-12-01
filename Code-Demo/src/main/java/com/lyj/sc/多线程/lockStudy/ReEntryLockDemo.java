package com.lyj.sc.多线程.lockStudy;

/**
 * @Author: liyangjing
 * @Date: 2022/08/11/22:06
 * @Description:
 */
public class ReEntryLockDemo {
    public static void main(String[] args) {
        final Object object = new Object();
        new Thread(()->{
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"\t 外层调用");
                synchronized (object){
                    System.out.println(Thread.currentThread().getName()+"\t 中层调用");
                    synchronized (object){
                        System.out.println(Thread.currentThread().getName()+"\t 内层调用");
                    }
                }
            }
        });
    }
}
