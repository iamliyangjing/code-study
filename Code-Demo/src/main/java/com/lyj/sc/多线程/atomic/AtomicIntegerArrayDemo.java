package com.lyj.sc.多线程.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-08-20 14:50
 **/
public class AtomicIntegerArrayDemo {

    public static void main(String[] args) {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[5]);
        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            System.out.println(atomicIntegerArray.get(i));
        }

        System.out.println();

        int temInt=0;

        temInt = atomicIntegerArray.getAndSet(0,1122);
        System.out.println(temInt+"\t"+atomicIntegerArray.get(0));

        temInt = atomicIntegerArray.getAndIncrement(0);
        System.out.println(temInt+"\t"+atomicIntegerArray.get(0));
    }
}
