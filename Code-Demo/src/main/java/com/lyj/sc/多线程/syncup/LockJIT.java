package com.lyj.sc.多线程.syncup;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-09-02 17:35
 **/
public class LockJIT {
    static Object objectLock= new Object();
    public void m1(){
        //锁消除问题，JIT编译器无视他，synchronized(o)，每次new出来，不存在
        //每个线程一把锁
        Object o = new Object();
        synchronized (o){
            System.out.println("----hello lockjit"+"\t"+o.hashCode()+"\t"+objectLock.hashCode());
        }
    }

    public static void main(String[] args) {
        LockJIT lockJIT = new LockJIT();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                lockJIT.m1();
            },String.valueOf(i)).start();
        }
    }
}
