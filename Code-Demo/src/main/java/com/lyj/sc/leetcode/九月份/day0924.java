package com.lyj.sc.leetcode.九月份;

import java.util.Arrays;
import java.util.Map;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-24 11:15
 **/
public class day0924 {

    public static int[] decrypt(int[] code, int k) {
        int len =  code.length;
        int[] res = new int[len];
        if(k==0){
            Arrays.fill(res,0);
        } else if(k<0){
            k = Math.abs(k);
            for (int i = 0; i < len; i++) {
                for (int j = 1; j <= k; j++) {
                    res[i]+=code[(i+len-j)%len];
                }
            }
        }else {
            for (int i = 0; i < len; i++) {
                for (int j = 1; j <=k; j++) {
                    res[i]+=code[(i+j)%len];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        decrypt(new int[]{2,4,9,3},-2);
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix.length==0 || matrix[0].length==0 || matrix==null){
            return 0;
        }
        int rows = matrix.length;
        int coloums = matrix[0].length;
        int[][] dp = new int[rows][coloums];
        int maxSide=0;
        for (int row = 0; row < rows; row++) {
            for (int coloum = 0; coloum < coloums; coloum++) {
                if (matrix[row][coloum]=='1'){
                    if(coloum==0 || row==0){
                        dp[row][coloum]++;
                    }else {
                        dp[row][coloum]=Math.min(dp[row-1][coloum],Math.min(dp[row][coloum-1],dp[row-1][coloum-1]))+1;
                    }
                    maxSide=Math.max(maxSide,dp[row][coloum]);
                }
            }
        }
        return maxSide*maxSide;
    }

    public int countSquares(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0 || matrix==null){
            return 0;
        }
        int rows = matrix.length;
        int coloums = matrix[0].length;
        int[][] dp = new int[rows][coloums];
        int ans = 0;
        for (int row = 0; row < rows; row++) {
            for (int coloum = 0; coloum < coloums; coloum++) {
                if(matrix[row][coloum]==0){
                    dp[row][coloum]=0;
                }
                else if(row==0 || coloum==0){
                    dp[row][coloum]++;
                }else {
                    dp[row][coloum]=Math.min(Math.min(dp[row-1][coloum],dp[row][coloum-1]),dp[row-1][coloum-1])+1;
                }
                ans+=dp[row][coloum];
            }
        }
        return ans;
    }
}
