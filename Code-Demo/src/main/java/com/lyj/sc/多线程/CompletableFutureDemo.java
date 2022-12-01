package com.lyj.sc.多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: liyangjing
 * @Date: 2022/07/21/22:38
 * @Description:
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyThread2());
        Thread t1 = new Thread(futureTask, "t1");
        t1.start();;
        System.out.println(futureTask.get());
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("---- come in call()");
        return "hello callable!";
    }
}
