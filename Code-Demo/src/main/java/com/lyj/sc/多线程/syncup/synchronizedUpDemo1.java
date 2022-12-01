package com.lyj.sc.多线程.syncup;

import org.openjdk.jol.info.ClassLayout;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-08-26 14:45
 **/
public class synchronizedUpDemo1 {

    public static void main(String[] args) {
        Object o = new Object();

        System.out.println(o.hashCode());
        System.out.println(Integer.toHexString(o.hashCode()));
        System.out.println(Integer.toBinaryString(o.hashCode()));
        //hashcode 调用 才有
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
