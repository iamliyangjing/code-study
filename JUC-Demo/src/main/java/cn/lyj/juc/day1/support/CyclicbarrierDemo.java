package cn.lyj.juc.day1.support;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2023-01-30 12:03
 **/
public class CyclicbarrierDemo {
    //创建固定值
    private static final int NUMBER = 7;
    public static void main(String[] args) {
        //创建ciclicbarrier
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER, () -> {
            System.out.println("******* 龙珠再现");
        });

        // 集齐七颗龙珠过程
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"星龙被收集到了");
                //等待
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            },String.valueOf(i)).start();
        }
    }
}
