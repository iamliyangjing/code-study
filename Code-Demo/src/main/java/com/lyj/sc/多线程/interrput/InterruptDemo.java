package com.lyj.sc.多线程.interrput;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author: liyangjing
 * @Date: 2022/08/13/12:10
 * @Description:
 */
public class InterruptDemo {
    static volatile boolean isStop = false;
    static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                //获取当前线程是否被中断过
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "\tisStop的值被修改为ture，程序停止");
                    break;
                }
                System.out.println("-----hello interrupt api");
            }
        }, "t1");
        t1.start();
        System.out.println("t1默认中断标志位"+t1.isInterrupted());
        TimeUnit.MILLISECONDS.sleep(20);
        new Thread(()->{
            t1.interrupt();
        },"t2").start();
    }

    public static void m1_atomicBoolean() throws InterruptedException {
        new Thread(()->{
            while (true){
                if(atomicBoolean.get()){
                    System.out.println(Thread.currentThread().getName()+"\tisStop的值被修改为ture，程序停止");
                    break;
                }
                System.out.println("-----hello volatile");
            }
        },"t1").start();
        //暂停毫秒
        TimeUnit.MILLISECONDS.sleep(20);

        new Thread(()->{
            atomicBoolean.set(true);
        },"t2").start();
    }

    public static void m1_volatile() throws InterruptedException {
        new Thread(()->{
            while (true){
                if(isStop){
                    System.out.println(Thread.currentThread().getName()+"\tisStop的值被修改为ture，程序停止");
                    break;
                }
                System.out.println("-----hello volatile");
            }
        },"t1").start();
        TimeUnit.MILLISECONDS.sleep(20);

        new Thread(()->{
            isStop=true;
        },"t2").start();
    }


}
