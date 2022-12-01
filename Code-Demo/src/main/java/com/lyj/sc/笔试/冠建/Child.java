package com.lyj.sc.笔试.冠建;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-24 19:56
 **/
public class Child  extends Father{
    public int i=1;
    public Child(){
        System.out.println("woshi child");
    }

    public static void main(String[] args) {
        Child child = new Child();
    }
}
