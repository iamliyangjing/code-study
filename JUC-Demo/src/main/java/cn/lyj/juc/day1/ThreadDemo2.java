package cn.lyj.juc.day1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2023-01-30 11:27
 **/
// 第一步 创建资源类 ，定义属性和操作方法
    class share{
        private int number = 0;

    // 创建 lock
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //+1
    public void  incr(){
        // 上锁
        lock.lock();
        try {
            //判断
            while (number!=0){
                condition.await();
            }
            //干活
            //如果number是0，就+1操作
            number++;
            System.out.println(Thread.currentThread().getName()+"::"+number);
            // 通知
            condition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }

    //-1
    public void  decr(){
        // 上锁
        lock.lock();
        try {
            //判断
            while (number==0){
                condition.await();
            }
            //干活
            //如果number是0，就+1操作
            number--;
            System.out.println(Thread.currentThread().getName()+"::"+number);
            // 通知
            condition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }
}


public class ThreadDemo2 {

    public static void main(String[] args) {
        Share share = new Share();
        //创建线程
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.incr();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"AA").start();
    }
}
