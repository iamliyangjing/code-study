package com.lyj.sc.多线程.ObjectHead;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-08-25 16:20
 **/
public class ObjectHeadDemo {

    public static void main(String[] args) {
        Object o = new Object(); // ? new一个对象 ，占内存多少？

        System.out.println(o.hashCode()); // 这个hashcode记录在对象的什么地方

        synchronized (o){

        }

        System.gc();// 手动收集垃圾。。。。。，15次可以从新生代--养老区
        Customer c1 = new Customer();

    }
}

class Customer{ //只有一个对象头的实例对象，16个字节（忽略压缩指针的影响）+4字节+1字节=21字节
    int id;
    String ClassName;
    boolean flag = true;
}
