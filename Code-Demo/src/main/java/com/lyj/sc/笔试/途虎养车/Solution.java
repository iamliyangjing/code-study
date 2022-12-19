package com.lyj.sc.笔试.途虎养车;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-06 19:41
 **/
public class Solution {

    public static int lastGlassWaterVol(int[] waters) {
        // write code here
        Arrays.sort(waters);
        int i1=0;
        int j= waters.length-1;
        while (i1<j){
            int t=waters[i1];
            waters[i1]=waters[j];
            waters[j]=t;
            i1++;
            j--;
        }
        System.out.println(Arrays.toString(waters));
        for (int i = 1; i < waters.length; i++) {
            if (waters[i] < waters[i - 1]) {
                waters[i] = waters[i - 1] - waters[i];
            } else if (waters[i] == waters[i - 1]) {
                waters[i] = waters[i - 1] = 0;
            }
        }
        System.out.println(Arrays.toString(waters));
        return waters[waters.length - 1];
    }

    public static void main(String[] args) {
        lastGlassWaterVol(new int[]{1,7,4,2,8,1});
    }
}
