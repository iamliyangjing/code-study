package com.lyj.sc.多线程.interrput;

import java.util.concurrent.TimeUnit;

/**
 * @Author: liyangjing
 * @Date: 2022/08/13/12:10
 * @Description:
 */
public class InterruptDemo3 {

    public static void main(String[] args) throws InterruptedException {
        //实例方法interrupt()仅仅时设置线程的中断状态位为ture
        Thread t1 = new Thread(() -> {
            while (true){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread().getName()+"\t"+
                            Thread.currentThread().isInterrupted()+"标志位");
                        break;
                }
                //程序不会停下来，因为sleep方法抛出interruptException后，中断标志位被重置为false，标志位会被clear
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    //再次调用interrupt
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
                System.out.println("----hello interrupt Demo3");
            }
        }, "t1");
        t1.start();

        //暂停几秒钟线程
        TimeUnit.SECONDS.sleep(1);
        new Thread(()-> t1.interrupt(),"t2").start();
    }

}

/**
 * 1 中断标志位 ，默认为false
 *
 * 2 t 2 ----》 t1发出了中断协商， t2调用t1.interrupt（），中断标志位true
 *
 * 3.中断标志位true , 正常情况，程序停止
 *
 * 4.中断标志位true，异常情况，interruptedException，将会把中断状态清楚，并且将收到interruptedException，中断标志位false
 *      导致无线循环
 *
 * 5.在catch块里，需要二再次给中断标志位设置为true，2次调用停止程序才ok
 */