package com.lyj.sc.笔试.同花顺;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-10 16:27
 **/
public class Test extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("run");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.run();;
        System.out.println("main");
    }
}
