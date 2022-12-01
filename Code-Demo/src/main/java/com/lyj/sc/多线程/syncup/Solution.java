package com.lyj.sc.多线程.syncup;

import java.util.*;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-08-31 21:29
 **/
class Solution{
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int n  = sc.nextInt();
        int [] a = new int[n];
        int [] a1 = new int[n];
        int k=0;
        for(int i=0;i<n;i++){
            k  = sc.nextInt();
            a[i]=k;
        }
        for(int i=0;i<n;i++){
            k  = sc.nextInt();
            a1[i]=k;
        }
        Set<Integer> set= new HashSet<>();
        int count=0;
        for(int i=0;i<n;i++){
            set.add(a[i]);
            for(int j=0;j<n;j++){
                set.remove(a1[j]);
                if(a[i]==a[j]){
                    if(i>j){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static int findPairs(List<Integer> array, int k) {
        int len = array.size();
        int count=0;
        for (int i = 0; i < len-1; i++) {
            for (int j = len-1; j >i ; j--) {
                int sum = array.get(i) + array.get(j);
                if(sum%k==0){
                    count++;
                }
            }
        }
        return count;
    }

    public static List<Integer> sum_two(List<Integer> input_array) {
        // Write your code here
        if(input_array.size()==2){
            return input_array;
        }
        int len = input_array.size();
        while (input_array.size()!=2){
            len=len/2;
            for (int i = 0; i < len; i++) {
                //获得left结点保存
                Integer temp = input_array.get(i);
                // 移除left
                input_array.remove(i);
                //添加
                input_array.add(i,temp+input_array.get(input_array.size()-1));
                //删除right
                input_array.remove(input_array.size()-1);
            }
        }
        return input_array;
    }

    public static List<Integer> even_and_odds(List<Integer> numbers) {
        List<Integer> res = new ArrayList<>();
        // Write your code here
        int len = numbers.size();
        int val=numbers.get(0);
        int lingCount=0;
        for (int i = 0; i < len; i++) {
            Integer t = numbers.get(i);
            if(t%2==0){
                if(t==0){
                    lingCount++;
                }else {
                    res.add(t);
                }
            }
        }
        Integer[] k = new Integer[res.size()+lingCount];
        for (int i = 0; i < res.size(); i++) {
            k[i]=res.get(i);
        }
        for (int i = res.size(); i < res.size()+lingCount; i++) {
            k[i]=Integer.MAX_VALUE;
        }
        Arrays.sort(k);
        for (int i = res.size(); i < res.size()+lingCount; i++) {
            k[i]=0;
        }
        return Arrays.asList(k);
    }
}