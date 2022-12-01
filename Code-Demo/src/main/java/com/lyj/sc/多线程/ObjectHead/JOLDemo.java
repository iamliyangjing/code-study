package com.lyj.sc.多线程.ObjectHead;

import org.openjdk.jol.info.ClassLayout;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-08-26 09:55
 **/
public class JOLDemo {
    public static void main(String[] args) {
//        Object o = new Object();
//        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        Customer1 customer1 = new Customer1();
        System.out.println(ClassLayout.parseInstance(customer1).toPrintable());

    }
}
class Customer1{
    int id;
    boolean flag = false;
    boolean flag1 = false;
}
