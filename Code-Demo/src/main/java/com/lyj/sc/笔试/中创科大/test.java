package com.lyj.sc.笔试.中创科大;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-19 15:46
 **/
public class test {
    public static String send() {
        String a="a";
        try {
            throw new Exception();
        }catch (Exception e){
            return a+"2";
        }finally {
            return a+"3";
        }
    }

    public static void main(String[] args) {
        System.out.println(send());
    }
}
