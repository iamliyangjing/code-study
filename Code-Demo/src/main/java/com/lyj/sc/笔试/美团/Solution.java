package com.lyj.sc.笔试.美团;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2023-03-18 10:54
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] number = s.split(" ");
        int a = Integer.parseInt(number[0]);
        int n = Integer.parseInt(number[1]);
        int [] num = new int[a];
        for (int i = 0; i < a; i++) {
            num[i] = scanner.nextInt();
        }
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            int count = 0;
            for (int j = i; j < num.length; j++) {
                if(set.size()<3 || set.contains(num[j])){
                    set.add(num[j]);
                    count++;
                }else {
                    if (count>max){
                        max=count;
                    }
                    break;
                }
            }
        }
        System.out.println(max);
    }
}
