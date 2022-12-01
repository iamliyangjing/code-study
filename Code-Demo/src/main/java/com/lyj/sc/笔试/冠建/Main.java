package com.lyj.sc.笔试.冠建;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-24 19:52
 **/
public class Main {
    public static void main(String[] args) {
        byte x = 64;
        int i =1;
        byte y;
        i=x<<2;
        y= (byte)(x<<2);
        System.out.println(i+":"+y);

        try {
            System.out.println(1);
//            int w=0/0;
        }catch (Exception e){
            System.out.println(2);
        }finally {
            System.out.println(3);
        }

    }
}
