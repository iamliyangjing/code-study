package com.lyj.sc.多线程.Cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: code-random
 * @description: 实现自旋锁
 *
 * 自旋锁好处： 循环比较获取没有类似wait的阻塞
 * 通过CAS操作实现自旋锁，A线程先进来调用mylock方法自己持有锁五秒钟，B随后进来后发现
 * 当前有线程持有锁，所有只能通过自旋等待，直到A释放锁B随后抢到。
 * @author: lyj
 * @create: 2022-08-19 21:30
 **/
public class SpinLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"come in");
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void unlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName()+"task over,unlock..");
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.lock();
            //暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            spinLockDemo.unlock();
        },"A").start();

        //暂停400毫秒
        TimeUnit.MILLISECONDS.sleep(400);

        new Thread(()->{
            spinLockDemo.lock();

            spinLockDemo.unlock();
        },"B").start();
    }
}
