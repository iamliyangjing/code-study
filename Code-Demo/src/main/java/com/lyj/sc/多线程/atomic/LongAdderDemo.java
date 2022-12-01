package com.lyj.sc.多线程.atomic;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.LongBinaryOperator;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-08-20 21:44
 **/
public class LongAdderDemo {

    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        longAdder.increment();
        longAdder.increment();
        longAdder.increment();

        System.out.println(longAdder.sum());
        //可以自定义累加
        LongAccumulator longAccumulator = new LongAccumulator((x,y)->x+y,0);
        LongAccumulator longAccumulator1 = new LongAccumulator(new LongBinaryOperator() {
            @Override
            public long applyAsLong(long left, long right) {
                return left+right;
            }
        }, 0);

        longAccumulator.accumulate(1);
        longAccumulator.accumulate(4);
        System.out.println(longAccumulator.get());
    }
}
