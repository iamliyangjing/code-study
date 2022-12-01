package com.lyj.sc.排序;

/**
 * @Author: liyangjing
 * @Date: 2022/03/07/11:20
 * @Description: 选择排序
 */
public class SelectSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        //判断是否为空 或者为1
        if(nums==null || nums.length<2){
            return nums;
        }
        //排序 从第一个开始选择 最小的 第二个 第三个。。。。
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]>nums[j]){
                    int temp = nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int [] a ={36,25,78,35,96,45,20,11};
        SelectSort selectSort = new SelectSort();
        for (int i : selectSort.sort(a)) {
            System.out.println(i);
        }
    }
}
