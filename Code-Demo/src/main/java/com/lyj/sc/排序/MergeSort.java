package com.lyj.sc.排序;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Author: liyangjing
 * @Date: 2022/03/21/10:20
 * @Description:
 */
public class MergeSort {

    public static void main(String[] args) {
        int [] a ={36,25,78,35,96,45,20,11};
        int[] sort = sort2(a, 0, a.length - 1);
        Stream.of(sort).forEach(t->System.out.println(Arrays.toString(t)));
    }

    /**
     * 归并排序
     * 简介:将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列
     * 时间复杂度为O(nlogn)
     * 稳定排序方式
     * @param nums 待排序数组
     * @return 输出有序数组
     */
    public static int[] sort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            sort(nums, low, mid);
            // 右边
            sort(nums, mid + 1, high);
            // 左右归并
            merge(nums, low, mid, high);
        }
        return nums;
    }

    /**
     * 将数组中low到high位置的数进行排序
     * @param nums 待排序数组
     * @param low 待排的开始位置
     * @param mid 待排中间位置
     * @param high 待排结束位置
     */
    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = nums[j++];
        }

        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }


    public static int[] sort2(int[] nums, int low, int high) {
        //mid
        int mid = (low+high)/2;
        if(low<high){
            //左边
            sort2(nums,low,mid);
            //右边
            sort2(nums,mid+1,high);
            //排序
            merge2(nums,low,mid,high);
        }
        return nums;
    }


    public static void merge2(int[] nums, int low, int mid, int high) {
        // 左
        int i=low;
        // 右
        int j=mid+1;
        int[] temp = new int[high-low+1];
        int k = 0;
        while (i<=mid && j<=high ){
            if(nums[i]<nums[j]){
                temp[k++]=nums[i++];
            }else {
                temp[k++]=nums[j++];
            }
        }
        while (i<=mid){
            temp[k++]=nums[i++];
        }
        while (j<=high ){
            temp[k++]=nums[j++];
        }
        //移到数组中
        for (int i1 = 0; i1 < temp.length; i1++) {
            nums[i1+low]=temp[i1];
        }
    }

}
