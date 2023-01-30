package cn.lyj.juc.day1.support;

import java.util.concurrent.CountDownLatch;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2023-01-30 11:55
 **/
// 演示 CountDownLatch
public class countDownLatchDemo {
    // 6个同学离开才能锁门
    public static void main(String[] args) throws InterruptedException {
        // 创建countdownlatch
        CountDownLatch countDownLatch = new CountDownLatch(6);
        // 6个同学陆续离开
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"号 离开了教室！");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"锁门走人");
    }

}
