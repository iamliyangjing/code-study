package com.lyj.sc.多线程.interrput;

/**
 * @Author: liyangjing
 * @Date: 2022/08/14/13:33
 * @Description:
 */
public class TestDemo {
    /**
     * 使用： 把value 定义为volatile变量，由于setter方法对value的修改不依赖value的原值，满足volatile关键字使用场景
     * 理由：利用volatile 保证读取操作的可见性，利用synchronized保证复合操作的原子性结合使用锁和volatile变量来减少同步的开销
     */
    private  volatile  int value = 0;

    public int getValue(){
        return value;
    }

    public synchronized int setValue(){
        return ++value;
    }
}
