package com.lyj.sc.leetcode.九月份;

import java.util.Arrays;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-09-20 09:50
 **/
public class day0920 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        //特殊情况
        //排序
        int target = 0;
        for (int num : nums) {
            target+=num;
        }
        //除不尽
        if(target%k!=0) return false;
        Arrays.sort(nums);
        int len = nums.length-1;
        int left =0;
        while (left<len){
            int temp = nums[len];
            nums[len]=nums[left];
            nums[left]=temp;
        }
        target=target/k;
        int[]bucket = new int[k+1];
        return backtrack(nums,target,bucket,0,k);
    }

    /**
     *
     * @param nums 球的数组
     * @param target 目标值 每个桶放多少个
     * @param bucket 桶的数组
     * @param index 遍历到nums的哪一个
     * @param k 桶的数量
     * @return
     */
    public boolean backtrack(int[] nums,int target,int[] bucket,int index,int k){
        if(index==nums.length){
            return true;
        }
        for (int i = 0; i < k; i++) {
            if(i>0 && index==0){
                break;
            }
            //若下一个值相等也是放一样的位置
            if(index>0 && nums[index-1]==nums[index]){
                continue;
            }
            if(nums[index]+bucket[i]>target) continue;
            // 加上
            bucket[i]+=nums[index];
            // 回溯,  index+1;
            if (backtrack(nums,target,bucket,index+1,k)) {
                return true;
            }
            //减去
            bucket[i]-=nums[index];
        }
        return  true;
    }

    /**
     * 581.最短无序连续子数组
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        // 把数组分为三段 左段 中段 右段
        int len = nums.length-1;
        int min  = nums[0];
        int max = nums[len];
        int begin=0;
        int end=0;
        for (int i = 0; i <= len; i++) {
            if(nums[i]<max){
                end=i;
            }else {
                max=nums[i];
            }

            if(nums[len-i]>min){
                begin=len-i;
            }else {
                min=nums[len-i];
            }
        }
        return end-begin;
    }
}
