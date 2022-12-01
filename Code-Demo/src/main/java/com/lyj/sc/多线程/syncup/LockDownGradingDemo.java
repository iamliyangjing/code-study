package com.lyj.sc.多线程.syncup;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-09-03 22:41
 **/
public class LockDownGradingDemo {
    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();

        readLock.lock();
        System.out.println("---读取");
        writeLock.lock();

        System.out.println("---写入");
        writeLock.unlock();

        readLock.unlock();
    }
}
