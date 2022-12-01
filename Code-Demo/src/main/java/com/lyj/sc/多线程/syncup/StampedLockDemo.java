package com.lyj.sc.多线程.syncup;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-09-04 20:29
 **/
public class StampedLockDemo {
    static int number = 37;
    static StampedLock stampedLock = new StampedLock();
    public void write(){
        long stamp = stampedLock.writeLock();
        System.out.println(Thread.currentThread().getName()+"\t"+"写线程准备修改");
        try {
            number=number+13;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
        System.out.println(Thread.currentThread().getName()+"\t"+"写线程结束修改");
    }

    public void read() throws InterruptedException {
        long stamp = stampedLock.readLock();
        System.out.println(Thread.currentThread().getName()+"读线程准备读");
        for (int i = 0; i < 4; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName()+"正在读取");
        }

        try {
            int res = number;
            System.out.println(Thread.currentThread().getName()+"\t"+"获得成员变量值"+res);
            System.out.println("写线程没有修改成功，读锁的时候写锁无法介入，传统的读写互斥");
        } finally {
            stampedLock.unlockRead(stamp);
        }
    }

    // 乐观锁 ，读的过程中允许获取写锁介入
    public void tryOptimisticRead(){
        long stamp = stampedLock.tryOptimisticRead();
        int result=number;

        System.out.println("4秒前stampedLock.validate方法值(true 无修改，false有修改)"+"\t"+stampedLock.validate(stamp));
        for (int i = 0; i < 4; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+
                    "\t"+"正在读取。。。"+i+"秒"+"后stampedLock.validate方法值(true 无修改，false有修改)"+stampedLock.validate(stamp));
        }
        if(!stampedLock.validate(stamp)){
            System.out.println("有人修改过---写操作");
            stamp = stampedLock.readLock();
            try {
                System.out.println("从乐观锁 升级为 悲观读");
                result=number;
                System.out.println("重新悲观读后 result:" +result);
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }
        System.out.println(Thread.currentThread().getName()+"\t"+"finally val ="+result);

    }

    public static void main(String[] args) throws InterruptedException {
        StampedLockDemo stampedLockDemo = new StampedLockDemo();
        new Thread(()->{
            stampedLockDemo.tryOptimisticRead();
        },"readThread").start();
        //暂停两秒钟的线程，读过程可以写介入，演示
        TimeUnit.SECONDS.sleep(2);

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"come in");
            stampedLockDemo.write();
        },"writeThread").start();
    }
}
