package com.lyj.sc.多线程.ThreadLocalDemo;

import java.lang.ref.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-08-25 13:22
 **/
class MyObject{
    @Override
    protected void finalize() throws Throwable {
        //finalize 的通常目的是在对象被不可撤的丢弃之前执行清理操作
        System.out.println("--------invoke finalize method~");
    }
}


public class ReferenceDemo {

    public void function(){
        ThreadLocal<String> objectThreadLocal = new ThreadLocal<>();
        objectThreadLocal.set("123456");
        objectThreadLocal.get();
    }

    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        //引用队列
        ReferenceQueue<MyObject> referenceQueue = new ReferenceQueue<>();
        //虚引用
        PhantomReference<MyObject> myObjectPhantomReference = new PhantomReference<>(myObject,referenceQueue);
        System.out.println(myObjectPhantomReference.get());

        List<byte []> list = new ArrayList<>();
        new Thread(()->{
            while (true){
                list.add(new byte[1*1024*1024]);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(myObjectPhantomReference.get()+"\t"+"list add ok");
            }
        },"t1").start();


        new Thread(()->{
            while (true){
                Reference<? extends MyObject> reference = referenceQueue.poll();
                if(reference!=null){
                    System.out.println("-------有虚对象回收假如了队列");
                }
            }
        },"t2").start();
    }

    public static void weakReference(String[] args) throws InterruptedException {
        WeakReference<MyObject> weakReference = new WeakReference<>(new MyObject());
        System.out.println("----gc after内存够用"+weakReference.get());
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("内存不够:"+weakReference.get());
    }

    public static void softReference(String[] args) throws InterruptedException {
        SoftReference<MyObject> softReference = new SoftReference<>(new MyObject());
        System.out.println("----softReference"+softReference.get());
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("----gc after内存够用"+softReference.get());
        try {
            byte[] bytes = new byte[20 * 1024 * 1024];
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }            System.out.println("内存不够:"+softReference.get());


    }


    public static void StrongReference(String[] args) {
        MyObject myObject = new MyObject();
        System.out.println("gc before： "+myObject);
        myObject = null;
        //人工开启GC ，一般不用
        System.gc();
        System.out.println("gc after： "+myObject);
    }
}
