package com.lyj.sc.多线程.interrput;

/**
 * @Author: liyangjing
 * @Date: 2022/08/13/14:28
 * @Description:
 */
public class InterruptDemo4 {
    public static void main(String[] args) {
        //测试当前线程是否被中断（检查中断标志），返回一个boolean
        //第二次调用时中断状态已经被清楚了，将返回一个false
        System.out.println(Thread.currentThread().getName()+"\t"+Thread.interrupted());
        System.out.println(Thread.currentThread().getName()+"\t"+Thread.interrupted());
        System.out.println("----1");
        Thread.currentThread().interrupt();//中断标志位设置为true
        System.out.println("----2");
        System.out.println(Thread.currentThread().getName()+"\t"+Thread.interrupted());
        System.out.println(Thread.currentThread().getName()+"\t"+Thread.interrupted());
    }
}
