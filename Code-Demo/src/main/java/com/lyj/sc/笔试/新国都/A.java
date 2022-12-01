package com.lyj.sc.笔试.新国都;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-28 14:44
 **/
public class A extends B{
    public A(){
        System.out.println("aaaaa");
    }
    static {
        System.out.println("woshiA");
    }

    public static void main(String[] args) {
        new A();
    }
}
