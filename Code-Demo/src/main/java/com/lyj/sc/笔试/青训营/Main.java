package com.lyj.sc.笔试.青训营;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2023-01-07 21:51
 **/
public class Main {
    public static int findProphet(int n, int[][] trust) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        //去除
        for (int i = 0; i < trust.length; i++) {
            set.remove(trust[i][0]);
        }
        if (set.size()==1){
            return set.stream().mapToInt(Integer::intValue).sum();
        }
        return -1;
    }

    public int solution(int n, String s) {
        // 请添加具体实现
        // FMMMFFMMFFMM
        // FMFMFM
        // FMMMFMMF
        char[] str = s.toCharArray();
        char start = str[0];
        char end = str[str.length];
        if (str.length==1 ||str==null){
            return 0;
        }
        int count = 0;
        return 0;
    }

    public static void main(String[] args) {
        int[][] i = new int[100][2];
        int prophet = findProphet(3, new int[][]{{1, 2},{3,2}});
        System.out.println(prophet);
    }
}
