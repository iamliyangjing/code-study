package com.lyj.sc.多线程.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-08-20 15:01
 *
 *
 **/
public class AtomicMarkableReferenceDemo {

    static AtomicMarkableReference atomicMarkableReference = new AtomicMarkableReference(100,false);

    public static void main(String[] args) {
            new Thread(()->{
                boolean marked = atomicMarkableReference.isMarked();
                System.out.println(Thread.currentThread().getName()+"\t"+"默认标识位"+marked);
                //暂停几秒钟
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                atomicMarkableReference.compareAndSet(100,1000,marked,!marked);

            },"t1").start();

        new Thread(()->{
            boolean marked = atomicMarkableReference.isMarked();
            System.out.println(Thread.currentThread().getName()+"\t"+"默认标识位"+marked);
            //暂停几秒钟
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            boolean b = atomicMarkableReference.compareAndSet(100, 2000, marked, !marked);
            System.out.println(Thread.currentThread().getName()+" "+b);
            System.out.println(Thread.currentThread().getName()+" "+atomicMarkableReference.getReference());
            System.out.println(Thread.currentThread().getName()+" "+atomicMarkableReference.isMarked());
        },"t2").start();
    }

}
