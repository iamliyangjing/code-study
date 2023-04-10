package com.lyj.sc.笔试.航天;

import java.io.File;
import java.io.IOException;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2023-03-14 23:49
 **/
public class Solution {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        opreate(a,b);
        System.out.println(a+","+b);
    }

    static void  opreate(StringBuffer x,StringBuffer y){
        y.append(x);
        y=x;
    }
}

class A{
    public int i=0;
    public A(){
        i=2;
    }
    public int getn(int a){
        return a+1;
    }
}

class B extends A{

    public B(){
        i=1;
    }
    public int getn(int a, char c){
        return a+2;
    }

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.getn(0));
    }
}
