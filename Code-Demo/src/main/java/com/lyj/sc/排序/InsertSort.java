package com.lyj.sc.排序;

/**
 * @Author: liyangjing
 * @Date: 2022/03/07/11:15
 * @Description:
 */
public class InsertSort implements Sort {

    @Override
    public int[] sort(int[] nums) {
        //判断是否为空 或者为1
        if(nums==null || nums.length<2){
            return nums;
        }
        //i 代表待插入元素的索引
        for (int i = 1; i < nums.length; i++) {
            int t = nums[i]; //代表待插入元素值
            int j =i-1;  //代表已排序区域的元素索引
            while (j>=0){
                if(t<nums[j]){
                    nums[j+1]=nums[j];
                }else {
                    break;
                }
                j--;
            }
            //填充值
            nums[j+1]=t;
        }
        return nums;
    }
    public static void main(String[] args) {
        int [] a ={36,25,78,35,96,45,20,11};
        InsertSort insertSort = new InsertSort();
        for (int i : insertSort.sort(a)) {
            System.out.println(i);
        }
    }
}
