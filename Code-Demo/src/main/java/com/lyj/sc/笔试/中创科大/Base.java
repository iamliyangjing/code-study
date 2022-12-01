package com.lyj.sc.笔试.中创科大;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-19 15:40
 **/
public class Base extends Derived{
    public Base(String s){
        super("D");
    }

    public static void main(String[] args) {
        new Derived("C");
    }
}

class Derived{
    public Derived(String s){
        System.out.println("B");
    }
}
