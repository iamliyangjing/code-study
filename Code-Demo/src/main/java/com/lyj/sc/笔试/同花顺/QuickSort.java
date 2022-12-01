package com.lyj.sc.笔试.同花顺;

import java.util.Arrays;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-10 16:42
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{78,98,2,0,83,78,54,32,78,83,8};
        quick(nums,0,nums.length-1);
    }

    public static void quick(int [] nums,int low,int high){
        if(low>=high){
            return;
        }
        int pv = nums[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if(nums[j]<pv){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,high);
        System.out.println(Arrays.toString(nums));
        quick(nums,low,i-1);
        quick(nums,i+1,high);
    }

    public static void swap(int [] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public void sortLin(int [] nums){
        int n=nums.length;
        int[] k = new int[n];
        int m = 0;
        for (int num : nums) {
            k[m++]=num;
        }
        for (int i = m; i < n; i++) {
            k[i]=0;
        }
    }
}
