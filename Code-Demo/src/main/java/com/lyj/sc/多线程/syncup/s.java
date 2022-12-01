package com.lyj.sc.多线程.syncup;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-09-02 17:20
 **/
public class s {
    public static void main(String[] args) throws InterruptedException {
//        TimeUnit.SECONDS.sleep(5);
//        Object o = new Object();
//        System.out.println("本应该是偏向锁");
//        System.out.println(ClassLayout.parseInstance(o).toPrintable());
//
//        o.hashCode();
//        synchronized (o){
//            System.out.println("本应该是偏向锁,调用了hashcode");
//            System.out.println(ClassLayout.parseInstance(o).toPrintable());
//        }
        // 发生重量级
        TimeUnit.SECONDS.sleep(5);
        Object o = new Object();
        System.out.println("本应该是偏向锁");
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o){
            o.hashCode();
            System.out.println("本应该是偏向锁,调用了hashcode");
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
