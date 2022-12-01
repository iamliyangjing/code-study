package com.lyj.sc.多线程.ThreadLocalDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-08-25 11:26
 **/
class MyData{
    ThreadLocal<Integer> threadLocalfield = ThreadLocal.withInitial(()->0);
    public void add(){
        threadLocalfield.set(1+threadLocalfield.get());
    }
}
public class ThreadDemo2 {
    public static void main(String[] args) {
        MyData myData = new MyData();
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        try {
            for (int i =0;i<=10;i++){
                threadPool.submit(()->{
                    try {
                        Integer beforInt = myData.threadLocalfield.get();
                        myData.add();
                        Integer afterInt = myData.threadLocalfield.get();
                        System.out.println(Thread.currentThread().getName()+"\t before"+beforInt+"\t after"+afterInt);
                    } finally {
                        myData.threadLocalfield.remove();
                    }
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            threadPool.shutdown();
        }
    }
}
