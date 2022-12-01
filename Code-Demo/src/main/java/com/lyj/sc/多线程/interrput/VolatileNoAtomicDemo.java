package com.lyj.sc.多线程.interrput;

import java.util.concurrent.TimeUnit;

/**
 * @Author: liyangjing
 * @Date: 2022/08/14/15:59
 * @Description:
 */
public class VolatileNoAtomicDemo {
    private volatile int number;

    public  void  addPlusPlus(){
        number++;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileNoAtomicDemo volatileNoAtomicDemo = new VolatileNoAtomicDemo();
        for (int i=1;i<=10;i++){
            new Thread(()->{
                for (int j=1;j<=1000;j++){
                    volatileNoAtomicDemo.addPlusPlus();
                }
            },String.valueOf(i)).start();
        }

        TimeUnit.SECONDS.sleep(2);

        System.out.println(volatileNoAtomicDemo.number);
    }
}
