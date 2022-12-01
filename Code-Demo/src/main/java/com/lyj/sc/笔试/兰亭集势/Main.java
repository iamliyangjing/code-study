package com.lyj.sc.笔试.兰亭集势;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-19 19:02
 **/
public class Main {
    public String longestPalindrome(String s) {
        // 动态规划
        int len = s.length();
        if(len<2){
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i]=true;
        }

        int maxLen = 1;
        int begin = 0;
        //长度
        for (int L = 2; L <=len ; L++) {
            for (int i = 0; i < len; i++) {
                // L = j-1+1
                int j = L+i-1;
                if(j>=len){
                    break;
                }
                if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j]=false;
                }else {
                    if(j-i<3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && maxLen<j-i+1){
                    begin=i;
                    maxLen=j-i+1;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}

