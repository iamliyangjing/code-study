package com.lyj.sc.排序;

/**
 * @Author: liyangjing
 * @Date: 2022/03/07/10:57
 * @Description: 冒泡排序
 */
public class BubbleSort{

    public static int[] sort(int[] nums){
        if(nums==null||nums.length<2){
            return nums;
        }
        int temp;
        //以每一个元素起点为守点
        for (int i = 0; i < nums.length-1; i++) {
            // 依次交换两个相近的元素 length-i-1 尾元素不判断
            for (int j = 0; j < nums.length-i-1; j++) {
                // j j+1 交换
                if(nums[j]>nums[j+1]){
                    temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        return nums;
    }

    public static int[] sort1(int[] nums){
        if(nums==null||nums.length<2){
            return nums;
        }
        //冒泡
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if(nums[j]>nums[j+1]){
                    temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int [] a ={36,25,78,35,96,45,20,11};
        for (int i : sort1(a)) {
            System.out.println(i);
        }
    }
}
