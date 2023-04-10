package com.lyj.sc.笔试.美团;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2023-03-18 10:07
 **/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] number = s.split(" ");
        int n = Integer.parseInt(number[0]);
        int a = Integer.parseInt(number[1]);
        int b = Integer.parseInt(number[2]);
        int[][] num = new int[n][2];
        for (int i = 0; i < n; i++) {
            num[i][0] = scanner.nextInt();
            num[i][1] = scanner.nextInt();
        }
        for (int[] ints : num) {
            System.out.println(Arrays.toString(ints));
        }
        //先排序
        int max = num[0][0];
        for (int i = 0; i < num.length-1; i++) {
            for (int j = i+1; j < num.length; j++) {
                    if(num[i][0]>num[j][0]){
                       int temp1 = num[i][0];
                       int temp2 = num[i][1];
                       num[i][0] = num[j][0];
                       num[i][1] = num[j][1];
                       num[j][0] = temp1;
                       num[j][1] = temp2;
                    }
            }
        }
        for (int i = 0; i < num.length; i++) {
            System.out.println(Arrays.toString(num[i]));
        }
        // 计算
        int maxCount = 0;
        for (int i = 0; i < num.length; i++) {
            int count = 1;
            int minX = num[i][0];
            int minY = num[i][1];
            for (int j = i+1; j < num.length; j++) {
                if (minX-num[j][0]<=a &&
                Math.abs(minY-num[j][1])<=b){
                    if (minX>num[j][0]){
                        minX = num[j][0];
                    }
                    if (minY>num[j][1]){
                        minY = num[j][1];
                    }
                    count++;
                    if(count>maxCount){
                        maxCount=count;
                    }
                }
            }
        }
        System.out.println(maxCount);
    }
}
