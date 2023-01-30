package cn.lyj.juc.day1.support;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2023-01-30 12:08
 **/
// 6 辆车 三个停车位
public class SemaphoreDemo {
    public static void main(String[] args) {
        //创建semaphore 设置许可数量
        Semaphore semaphore = new Semaphore(3);

        // 模拟6辆汽车
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                //抢占
                try {
                    semaphore.acquire();

                    System.out.println(Thread.currentThread().getName()+"抢到了车位!");

                    // 设置随机停车时间
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));

                    System.out.println(Thread.currentThread().getName()+"离开了车位!");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
