package com.lyj.sc.笔试.亚信安全;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-28 19:51
 **/
public class Main {

    public boolean testValid (String str) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==']'){
                if(stack.peek()!='['){
                    return false;
                }
                stack.pop();
                continue;
            }
            if(str.charAt(i)=='}'){
                if(stack.peek()!='{'){
                    return false;
                }
                stack.pop();
                continue;
            }
            if(str.charAt(i)==')'){
                if(stack.peek()!='('){
                    return false;
                }
                stack.pop();
                continue;
            }
            stack.push(str.charAt(i));
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * 求最后的胜利者 (约瑟夫环)
     * @param N
     * @param m
     * @return
     */
    public  static int cal (int N, int m) {
        // write code here
        //1 2 3 4 5 6 7 8 9 10
        //1 2   4 5   7 8   10
        //      4 5     8   10
        //      4 5         10
        //      4           10
        //      4
        int ans = 0;
        for (int i = 2; i <= N; i++) {
            ans=(ans+m)%i;
        }
        return ans+1;
    }


//    public long countPatient (int days) {
//        // write code here
//        // 发病状态下每天感染3个
//        // 第十四天自愈
//        // 潜伏6天
//
//    }
    public static void main(String[] args) {
        System.out.println(cal(10, 3));
    }
}
