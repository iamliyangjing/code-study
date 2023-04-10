package com.lyj.sc.笔试.浩鲸;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2023-03-21 22:55
 **/
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] student = new int[n];
        for (int i = 0; i < n; i++) {
            student[i]=scanner.nextInt();
        }
        int k = scanner.nextInt();
        int d = scanner.nextInt();
        //System.out.println(n+" "+ Arrays.toString(student)+" "+k+" "+d);
        Arrays.sort(student);
        if(k>n){
            System.out.println(0);
            return;
        }
        int sum = 1;
        int m=0;
        for (int i = n-1; i > 0; i--) {
            if(Math.abs(student[i]-student[i-1])<d){
                sum=sum*student[i];
            }
        }
        System.out.println(sum);
    }
}
