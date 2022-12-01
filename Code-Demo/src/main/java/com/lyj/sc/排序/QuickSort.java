package com.lyj.sc.排序;

import java.util.Arrays;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-21 15:38
 **/
public class QuickSort{

    public static void main(String[] args) {
        int [] a ={36,25,78,35,96,45,20,11};
        QuickSort q = new QuickSort();
        q.quick(a,0,a.length-1);
    }

    //单边循环

    /**
     * 思路：
     * 1.找到基准点
     * 2.以最低点遍历，每次遍历看是否比基准点PV大或者小
     * 3.遍历完，交换基准点最右和i ， 递归Sort遍历
     * @param nums
     * @param left
     * @param right
     */
    public  void quick(int[] nums,int left,int right){
        if(left>right){
            return;
        }
        sort2(nums,left,right);
    }
    public void sort(int[] nums,int left,int right) {
        if(left>=right){
            return;
        }
        int pv = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if(nums[j]<pv){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,right);
        System.out.println(Arrays.toString(nums));
        sort(nums,left,i-1);
        sort(nums,i+1,right);
    }

    public void swap(int[]nums,int l,int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r]=temp;
    }

    /**
     * 1. 找到基准点 左边
     * 2. 双指针比较 ，分别找到不符合要求的 进行交换。（先找到小的，在找到大的）
     * 3. 交换基准点值
     * 4. 分而治之
     * @param nums
     * @param left
     * @param right
     */
    public void sort2(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int pv = nums[left];
        int i=left;
        int j=right;
        while (i<j){
            while (i<j&&nums[j]>pv){
                j--;
            }
            while (i<j&&nums[i]<=pv){
                i++;
            }
            swap(nums,i,j);
        }
        swap(nums,left,j);
        System.out.println(Arrays.toString(nums));
        sort2(nums,left,j-1);
        sort2(nums,j+1,right);
    }
}
