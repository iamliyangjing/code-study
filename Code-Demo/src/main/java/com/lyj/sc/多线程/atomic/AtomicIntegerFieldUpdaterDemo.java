package com.lyj.sc.多线程.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-08-20 18:48
 **/
class BankAccount{
    String bankName="CCB";
    public volatile  int money=0;

    // 钱数
    public  void add(){
        money++;
    }
    // 因为对象的属性修改类型原子类都是抽象类，所以每次使用都必须
    // 使用静态方法newUpdater()创建一个更新器，并且需要设置想要更新的类
    AtomicIntegerFieldUpdater<BankAccount> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(BankAccount.class,"money");

    //不加synchronized ， 保证高性能原子性，局部微创小手术
    public void transMoney(BankAccount bankAccount){
        fieldUpdater.getAndIncrement(bankAccount);
    }
}

public class AtomicIntegerFieldUpdaterDemo {

    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        long startTime = System.currentTimeMillis();
        for(int i=1;i<=10;i++){
            new Thread(()->{
                try {
                    for(int j=1;j<=1000;j++){
//                        bankAccount.add();
                        bankAccount.transMoney(bankAccount);
                    }
                } finally {
                    countDownLatch.countDown();
                }
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime+"ms");
        System.out.println(Thread.currentThread().getName()+"\t"+"result"+bankAccount.money);
    }

}
