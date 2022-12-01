package com.lyj.sc.leetcode.九月份;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-26 17:25
 **/
public class day0926 {
    public int[] missingTwo(int[] nums) {
        int i = 0;
        for (int num : nums) {
            i^=num;
        }
        int n = nums.length+2;
        for (int j = 1; j <= n; j++) {
            i^=j;
        }
        int lsb = (i==Integer.MIN_VALUE?i:i&(-i));
        int type1=0,type2=0;
        for (int num : nums) {
            if((num&lsb)!=0){
                type1^=num;
            }else {
                type2^=num;
            }
        }
        for (int j = 1; j <= n; j++) {
            if((j&lsb)!=0){
                type1^=j;
            }else {
                type1^=j;
            }
        }
        return new int[]{type1,type2};
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int [] res = new int[n+2];
        for (int i = 0; i < n + 2; i++) {
            if(i==0 ||i==n+1){
                res[i]=1;
            }else {
                res[i]=nums[i-1];
            }
        }

        int [][] dp = new int[n+2][n+2];
        for (int i = n + 1; i >=0; i--) {
            for (int j = i + 1; j < n+2; j++) {
                for (int k = i+1; k < j; k++) {
                    dp[i][j]=Math.max(dp[i][j],dp[i][k]+dp[k][j]+res[i]*res[j]*res[k]);
                }
            }
        }
        return dp[0][n+1];
    }

    int ptr;
    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<>();
        ptr=0;
        while (ptr<s.length()){
            char cur = s.charAt(ptr);
            if(Character.isDigit(cur)){
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur)||cur=='[') {
                //获取第一个字母并进栈
               stk.addLast(String.valueOf(s.charAt(ptr++)));
            }else {
                //]
                ++ptr;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stk.peekLast())){
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                //左括号出栈
                stk.removeLast();
                //此时栈顶为当前sub对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuilder sb = new StringBuilder();
                String o = getString(sub);
                //构造字符串
                while (repTime-->0){
                    sb.append(o);
                }
                stk.addLast(sb.toString());
            }
        }
        //返回字符串
        return getString(stk);
    }
    
    public String getDigits(String s){
        StringBuffer sb = new StringBuffer();
        //可能不止一个字符
        while (Character.isDigit(s.charAt(ptr))){
            sb.append(s.charAt(ptr++));
        }
        return sb.toString();
    }
    
    public String getString(LinkedList<String> v){
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
    
    public static void main(String[] args) {
        int x = 2;
        int y = 1;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(-x));
        System.out.println(Integer.toBinaryString(x&-x));
    }
}
