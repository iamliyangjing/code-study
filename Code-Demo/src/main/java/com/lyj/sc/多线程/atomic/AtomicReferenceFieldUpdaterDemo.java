package com.lyj.sc.多线程.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-08-20 19:56
 **/
class Myvar{
    public volatile Boolean isInit = Boolean.FALSE;

    AtomicReferenceFieldUpdater<Myvar,Boolean> referenceFieldUpdater= AtomicReferenceFieldUpdater.newUpdater(Myvar.class,Boolean.class,"isInit");
    public void  init(Myvar myvar) throws InterruptedException {
        if (referenceFieldUpdater.compareAndSet(myvar,Boolean.FALSE,Boolean.TRUE)) {
            System.out.println(Thread.currentThread().getName()+"\t"+"3 seconds,need init");
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName()+"\t"+"init over");
        }else {
            System.out.println(Thread.currentThread().getName()+"\t"+"已经有线程在初始化工作");
        }
    }
}
public class AtomicReferenceFieldUpdaterDemo {

    public static void main(String[] args) {
        Myvar myvar = new Myvar();
        for(int i=1;i<=5;i++){
            new Thread(()->{
                try {
                    myvar.init(myvar);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            },String.valueOf(i)).start();
        }
    }
}
