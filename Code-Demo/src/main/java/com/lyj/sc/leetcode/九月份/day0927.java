package com.lyj.sc.leetcode.九月份;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-27 22:25
 **/
public class day0927 {
    public boolean CheckPermutation(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for (char c : c1) {
            str1.append(c);
        }
        for (char c : c2) {
            str2.append(c);
        }

        return str1.toString().equals(str2.toString());
    }
}
