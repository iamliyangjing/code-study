package com.lyj.sc.leetcode.十月份;

import java.util.Arrays;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-11 14:36
 **/
public class day1011 {
    public boolean areAlmostEqual(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        if(Arrays.equals(c1,c2)){
            return true;
        }
        if(c1.length!=c2.length){
            return false;
        }
        int j = -1;
        for (int i = 0; i < c1.length; i++) {
            if(c1[i]!=c2[i]){
                j=i;
                break;
            }
        }
        for (int i = (j + 1); i < c1.length; i++) {
            if(c1[i]!=c2[i]){
              char temp = c2[i];
              c2[i]=c2[j];
              c2[j]=temp;
              break;
            }
        }
        return Arrays.equals(c1,c2);
    }
}
