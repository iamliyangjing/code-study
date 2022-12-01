package com.lyj.sc.排序;

/**
 * @Author: liyangjing
 * @Date: 2022/03/07/14:53
 * @Description:
 */
public class ShellSort implements Sort{

    @Override
    public int[] sort(int[] nums) {
        //判断是否为空 或者为1
        if(nums==null || nums.length<2){
            return nums;
        }
        //记录数组的长度
        int length = nums.length;
        int temp;
        //记录步长
        int gap = length / 2;
//        如果步长大于0
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                temp = nums[i]; // 13
                int preIndex = i - gap; // 49
                while (preIndex >= 0 && nums[preIndex] > temp) {
                    nums[preIndex + gap] = nums[preIndex]; //
                    preIndex -= gap;
                }
                nums[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return nums;
    }

    public static void main(String[] args) {
        int [] a ={36,25,78,35,96,45,20,11};
        ShellSort shellSort = new ShellSort();
        for (int i : shellSort.sort1(a)) {
            System.out.println(i);
        }
    }

    public int[] sort1(int[] nums) {
        //判断是否为空 或者为1
        if(nums==null||nums.length<2){
            return nums;
        }
        //记录数组的长度
        int length = nums.length;
        int temp;
        //记录步长
        int gap = length/2;
        while (gap>0){
            for (int i = gap;i<length;i++){
                temp = nums[i];
                int preIndex = i-gap;
                while (preIndex>=0 && temp<nums[preIndex]){
                    nums[preIndex+gap] = nums[preIndex];
                    preIndex=preIndex-gap;
                }
                nums[preIndex+gap] = temp;
            }
            gap=gap/2;
        }
//        如果步长大于0
        return nums;
    }
}
