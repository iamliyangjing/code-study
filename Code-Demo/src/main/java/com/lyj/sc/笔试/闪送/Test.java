package com.lyj.sc.笔试.闪送;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-25 18:38
 **/
public class Test {
    public static void main(String[] args) {
        System.out.println(send());
    }

    public static int send(){
        try {
            return 0 ;
        }finally {
            return 1;
        }
    }
}
