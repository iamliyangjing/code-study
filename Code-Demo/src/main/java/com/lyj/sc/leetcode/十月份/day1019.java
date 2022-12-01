package com.lyj.sc.leetcode.十月份;

import java.util.Arrays;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-19 14:59
 **/
public class day1019 {
    public int countStudents(int[] students, int[] sandwiches) {
        int s1 = Arrays.stream(students).sum();
        int s0 = students.length-s1;
        for (int i = 0; i < sandwiches.length; i++) {
            if(sandwiches[i]==0 && s0>0){
                s0--;
            } else if (sandwiches[i]==1 && s1>0) {
                s1--;
            }else {
                break;
            }
        }
        return s1+s0;
    }
}
