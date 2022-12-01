package com.lyj.sc.多线程.ThreadLocalDemo;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-08-25 11:04
 **/
class House{
    int saleCount=0;
    public synchronized void saleHorse(){
        ++saleCount;
    }
    ThreadLocal<Integer> saleVolume = ThreadLocal.withInitial(()->0);
    public void saleVolumeByThreadLocal(){
        saleVolume.set(saleVolume.get()+1);
    }
}

public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        for(int i =1;i<=5;i++){
            new Thread(()->{
                int size = new Random().nextInt(5) + 1;
                try {
                    for (int j = 0; j < size; j++) {
                        house.saleHorse();
                        house.saleVolumeByThreadLocal();
                    }
                    System.out.println(Thread.currentThread().getName()+"\t"+"卖出"+house.saleVolume.get());
                } finally {
                    house.saleVolume.remove();
                }
                },String.valueOf(i)).start();
        }

        TimeUnit.MILLISECONDS.sleep(300);
        System.out.println(Thread.currentThread().getName()+"\t"+house.saleCount);
    }
}
