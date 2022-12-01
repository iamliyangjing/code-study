package com.lyj.sc.多线程.syncup;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-09-03 21:52
 **/
class MyResource{
    Map<String,String> map = new HashMap<>();
    // 等价于===synchronized
    Lock lock = new ReentrantLock();
    // 读写锁 读写互斥 读读共享
    ReadWriteLock rwLock = new java.util.concurrent.locks.ReentrantReadWriteLock();

    public void write(String key,String value){
        lock.lock();;
        try {
            System.out.println(Thread.currentThread().getName()+"\t"+"正在 写入");
            map.put(key,value);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"\t"+"写入 完成");
        } finally {
            lock.unlock();
        }
    }

    public void read(String key){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t"+"正在读取");
            String result = map.get(key);
            //读锁没有完成之前，写锁无法获得
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"\t"+"完成读取"+result);
        } finally {
            lock.unlock();
        }

    }

}

public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {
        MyResource myResource = new MyResource();
        for (int i = 0; i < 10; i++) {
            int FinalI  = i ;
            new Thread(()->{
                myResource.write(FinalI+"",FinalI+"");
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 10; i++) {
            int FinalI  = i ;
            new Thread(()->{
                myResource.read(FinalI+"");
            },String.valueOf(i)).start();
        }
    }
}
