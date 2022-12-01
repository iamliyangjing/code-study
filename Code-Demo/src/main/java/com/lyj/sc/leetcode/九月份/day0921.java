package com.lyj.sc.leetcode.九月份;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-09-21 11:02
 **/
public class day0921 {

    public  int ANS = Integer.MAX_VALUE;
    public int kSimilarity(String s1, String s2) {
        return dfs(s1.toCharArray(),s2.toCharArray(),0,0);
    }

    public int dfs(char[] str1,char[] str2,int start,int current){
        if(current >= ANS ) {
            return ANS;
        }
        if(start==str1.length-1) {
            return ANS=Math.min(ANS,current);
        }
        for (int i = start; i < str1.length; i++) {
            if(str1[i] != str2[i]){
                for (int j = i+1; j < str2.length; j++) {
                    if(str1[i] == str2[j]){
                        swap(str2,i,j);//交换
                        dfs(str1,str2,i+1,current+1);
                        swap(str2,i,j);//回溯
                    }
                }
                return current;
            }
        }
        return ANS = Math.min(ANS,current);
    }

    public void swap(char[] s2,int i,int j){
        char temp = s2[i];
        s2[i]  =  s2[j];
        s2[j]  = temp;
    }

    public int[] productExceptSelf(int[] nums) {
        //前缀 后缀
        int len = nums.length;
        int[] answer = new int[len];
        answer[0]=1;
        for (int i = 1; i < nums.length; i++) {
            answer[i]=answer[i-1]*nums[i-1];
        }

        int R = 1;
        for (int i = nums.length - 1; i >=0; i--) {
            answer[i]=answer[i]*R;
            R*=answer[i];
        }

        return answer;
    }
}
