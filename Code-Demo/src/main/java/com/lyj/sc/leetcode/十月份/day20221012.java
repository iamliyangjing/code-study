package com.lyj.sc.leetcode.十月份;

import com.lyj.sc.笔试.新国都.A;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-21 09:25
 **/
public class day20221012 {
}

class StockSpanner {
    public Deque<int []> stack;
    int idx ;
    public StockSpanner() {
        idx=-1;
        stack=new ArrayDeque<>();
        stack.push(new int[]{idx,Integer.MAX_VALUE});
    }
    public int next(int price) {
        idx++;
        while (price>=stack.peek()[1]){
            stack.pop();
        }
        int ret = idx-stack.peek()[0];
        stack.add(new int[]{idx,price});
        return ret;
    }
}