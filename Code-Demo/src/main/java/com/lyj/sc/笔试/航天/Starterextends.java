package com.lyj.sc.笔试.航天;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2023-03-15 00:27
 **/
public class Starterextends extends Thread{

private int x=2;
    public static void main(String[] args) throws Exception {
//        String s;
//        System.out.println("ss="+s);
        new Starterextends().makeItSo();
    }

    public Starterextends(){
        x = 5;
        start();
    }

    public void makeItSo() throws  Exception{
        join();
        x = x-1;
        System.out.println(x);
    }
    @Override
    public void run(){
        x*=2;
    }
}
