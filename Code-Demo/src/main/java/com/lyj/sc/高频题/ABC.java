package com.lyj.sc.高频题;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-09-04 09:36
 **/
public class ABC {
    public  static Thread t1;
    public static Thread t2;
    public void syn() {
        String a1 = "ABCDEF";
        String a2 = "123456";
        Object o = new Object();
        t1 = new Thread(() -> {

            synchronized (o){
                for (int i = 0; i < a1.length(); i++) {
                    System.out.println(a1.charAt(i));
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                o.notify();
            }
        });

         t2 = new Thread(() -> {
             synchronized (o){
                 for (int i = 0; i < a1.length(); i++) {
                     System.out.println(a2.charAt(i));
                     try {
                         o.notify();
                         o.wait();
                     } catch (InterruptedException e) {
                         throw new RuntimeException(e);
                     }
                 }
                 o.notify();
             }
        });

         t1.start();
         t2.start();
    }

    public  void locksupport() {
        String a1 = "ABCDEF";
        String a2 = "123456";
        Object o = new Object();
        t1 = new Thread(() -> {
                for (int i = 0; i < a1.length(); i++) {
                    System.out.println(a1.charAt(i));
                    LockSupport.unpark(t2);
                    LockSupport.park();
            }
        });

        t2 = new Thread(() -> {
                for (int i = 0; i < a1.length(); i++) {
                    LockSupport.park();
                    System.out.println(a2.charAt(i));
                    LockSupport.unpark(t1);
                 }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        String a1 = "ABCDEF";
        String a2 = "123456";

        Lock lock = new ReentrantLock();
        Condition condition2 = lock.newCondition();
        Condition condition1 = lock.newCondition();

        t1 = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < a1.length(); i++) {
                    System.out.println(a1.charAt(i));
                    condition2.signal();
                    try {
                        condition1.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            } finally {
                lock.unlock();
            }
        });

        t2 = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < a1.length(); i++) {
                    try {
                        condition2.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(a2.charAt(i));
                    condition1.signal();
                }
            } finally {
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
    }
}
