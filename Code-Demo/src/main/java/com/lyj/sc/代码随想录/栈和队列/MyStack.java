package com.lyj.sc.代码随想录.栈和队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-03 16:24
 **/
public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Queue<Integer> queueTmep;
        queueTmep=queue1;
        queue1=queue2;
        queue2=queueTmep;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.pop();
        myStack.push(3);
    }
}
