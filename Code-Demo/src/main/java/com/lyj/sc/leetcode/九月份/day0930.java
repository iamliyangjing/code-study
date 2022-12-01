package com.lyj.sc.leetcode.九月份;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-30 19:28
 **/
public class day0930 {

    public void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] coloums = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    rows[i]=coloums[j]=true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(rows[i]||coloums[j]){
                    matrix[i][j]=0;
                }
            }
        }
    }


}
