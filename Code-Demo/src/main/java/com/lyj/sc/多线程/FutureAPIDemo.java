package com.lyj.sc.多线程;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author: liyangjing
 * @Date: 2022/07/23/9:21
 * @Description:
 */
public class FutureAPIDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            System.out.println(Thread.currentThread().getName() + "\t------come in");
            //暂停几秒钟线程
            TimeUnit.SECONDS.sleep(5);
            return "task over";
        });
        Thread t1 = new Thread(futureTask, "t1");
        t1.start();
        System.out.println(futureTask.get());
        // 不见不散 非要等到结果才会离开，不管你是否计算完成
        System.out.println(Thread.currentThread().getName()+"\t ----忙其它任务了");
//        System.out.println(futureTask.get(3,TimeUnit.SECONDS));
//        while (true){
//            if(futureTask.isDone()){
//                System.out.println(futureTask.get());
//                break;
//            }else {
//                //暂停线程
//                TimeUnit.MILLISECONDS.sleep(500);
//                System.out.println("正在处理中");
//            }
//        }
    }
}

/**
 * 1. get 容易导致阻塞，一般建议放在程序后面，一旦调用不见不散，非要等到结果才会离开，不管你是否计算完成，容易程序阻塞。
 * 2. 假如我不愿意等待很长时间，我希望过时不候，可以自动离开。
 */