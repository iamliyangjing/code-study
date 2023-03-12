package com.lyj.sc.排序.test;

import com.lyj.sc.排序.QuickSort;
import com.lyj.sc.排序.Sort;

import java.util.Arrays;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2023-03-12 22:51
 **/
public class QuickSort1 implements Sort {
    @Override
    public int[] sort(int[] nums) {
        return new int[0];
    }

    public static void main(String[] args) {
        int [] a ={36,25,78,35,96,45,20,11};
        QuickSort1 q = new QuickSort1();
        q.s1(a,0,a.length-1);
    }

    public  void quick(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        sort2(nums,left,right);
    }

    public void sort2(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int pv = nums[right];
        int i = left;
        for (int j = left; j <=right ; j++) {
            if (nums[j]<pv){
                swap(nums,i,j);
                i++;
            }
        }
        //把right 移到中间来，左边比他小，右边比他大 递归开始
        swap(nums,i,right);
        System.out.println(Arrays.toString(nums));
        sort2(nums,left,i-1);
        sort2(nums,i+1,right);
    }

    public void swap(int[]nums,int l,int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r]=temp;
    }
    public void s1(int []nums,int left,int right){
        if(left>=right){
            return;
        }
        //1.找到一个基准点
        int pv = nums[left];
        int i=left;
        int j= right;
        while (i<j){
            while (i<j&&pv<nums[j]){
                j--;
            }
            while (i<j&&pv>=nums[i]){
                i++;
            }
            swap(nums,i,j);
        }
        // 因为j超过了i
        swap(nums,left,j);
        System.out.println(Arrays.toString(nums));
        s1(nums,left,j-1);
        s1(nums,j+1,right);
    }
}
