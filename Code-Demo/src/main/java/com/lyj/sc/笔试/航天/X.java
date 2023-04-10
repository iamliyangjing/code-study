package com.lyj.sc.笔试.航天;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2023-03-15 20:40
 **/
public class X {
    private static int a;


    public static void main(String[] args) {
        modify(a);
        System.out.println(a);
    }

    public static void modify(int a){
        a++;
    }
}
