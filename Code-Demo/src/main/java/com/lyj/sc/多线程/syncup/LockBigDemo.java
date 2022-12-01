package com.lyj.sc.多线程.syncup;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-09-02 17:39
 **/
public class LockBigDemo {
    // 假如方法中首尾相接，前后相邻的都是同一个锁对象，那JIT编译器就会把这几个synchronized块合并成一个大块，
    // 加粗加大范围，一次申请锁使用即可，避免此次的申请和释放锁，提升了性能。
    static Object objectLock=new Object();

    public static void main(String[] args) {
        new Thread(()->{
            // 叫做锁粗化
            // JIT 底层会给你将锁 优化成一个锁
            synchronized (objectLock){
                System.out.println("11111");
            }
            synchronized (objectLock){
                System.out.println("22222");
            }
            synchronized (objectLock){
                System.out.println("3333");
            }
            synchronized (objectLock){
                System.out.println("44444");
            }
        },"t1").start();
    }
}
