package com.lyj.sc.leetcode.九月份;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-23 11:01
 **/
public class day0923 {

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        int sum1=0;
        for (int i = 0; i <=len; i++) {
            sum1+=i;
        }
        return sum-sum1;
    }

    public  static  int[] countBits(int n) {
        int[] nums = new int[n+1];
        for (int i = 0; i <=n; i++) {
            nums[i]=Integer.bitCount(i);
        }
        return nums;
    }

    /**
     * 240. 搜索二维矩阵||
     * @param matrix
     * @param target
     * @return
     */


    public static void main(String[] args) {
//        String s1 = new String("1");
//        String s2 = s1;
//        System.out.println(s1==s2);
//        System.out.println(s1.equals(s2));
//        int i=0;
//        System.out.println(i++);
//        System.out.println(++i);

        List<Integer> list = new ArrayList<>();
//        list.add(2);
//        list.add(2);
//        list.add(3);
//        list.remove(new Integer(2));
        for (int i = 0; i < list.size(); i++) {
            if(list.contains(new Integer(2))){
                list.remove(new Integer(2));
            }
        }
        for (int i = 1; i <=20 ; i++) {
            list.add(i);
        }
        List<Integer> res = list.stream().filter(s -> {
            if (s < 15) {
                return false;
            }
            return true;
        }).collect(Collectors.toList());
        res.stream().forEach(s-> System.out.println(s));
    }
}
