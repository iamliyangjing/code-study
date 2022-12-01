package com.lyj.sc.Design;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-21 15:31
 **/
public class Singleton {
    private static volatile Singleton singleton;
    private Singleton(){

    }

    /**
     * 可能被破坏，通过反射的话。
     * @return
     */
    public static Singleton getInstance(){
     if (singleton==null){
         synchronized (Singleton.class){
            if(singleton==null){
                singleton = new Singleton();
            }
         }
     }
     return singleton;
    }
}
