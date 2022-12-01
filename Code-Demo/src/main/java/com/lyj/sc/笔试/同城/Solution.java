package com.lyj.sc.笔试.同城;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-21 19:21
 **/
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * maxSubArray
     * @param nums int整型一维数组 整数数组
     * @return int整型
     */
    public static int maxSubArray (int[] nums) {
        // write code here
        //动态规划
        int len = nums.length;
        int[] dp = new int[len];
        dp[0]=nums[0];
        for (int i = 1; i < len; i++) {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int max =dp[0];
        for (int i = 0; i < len; i++) {
            if(max<dp[i]){
                max=dp[i];
            }
        }
        return max;
    }


    public static String longestCommonPrefix (String[] strs) {
        // write code here
        int len = strs.length;
        if(len==1){
            return strs[0];
        }
        Arrays.sort(strs,(s1,s2)->{return s1.length()-s2.length();});
        String str = strs[0];
        char[] array = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            for (int j = 1; j < len; j++) {
                if(!strs[j].startsWith(sb.toString())){
                    sb.deleteCharAt(sb.length()-1);
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "hollis";
        String s2 = (new String("ho")+new String("llis")).intern();
        System.out.println(s1== s2);
    }

}