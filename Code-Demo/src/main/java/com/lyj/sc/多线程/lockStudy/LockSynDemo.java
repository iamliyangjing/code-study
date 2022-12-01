package com.lyj.sc.多线程.lockStudy;

/**
 * @Author: liyangjing
 * @Date: 2022/07/31/16:48
 * @Description:
 */
public class LockSynDemo {
    Object object = new Object();
    public void  m1(){
        synchronized (object){
            System.out.println("----hello synchronized");
        }
    }

    public static void main(String[] args) {

    }

}
