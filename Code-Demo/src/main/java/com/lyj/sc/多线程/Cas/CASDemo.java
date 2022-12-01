package com.lyj.sc.多线程.Cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 86183
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5,2022)+"\t"+atomicInteger.get());
    }
}
