package com.lyj.sc.代码随想录.数组;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-01 10:01
 **/
public class Solution {

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = left+(right-left)/2;
        while (left<=right){
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target) {
                left=mid+1;
            }else {
                return mid;
            }
            mid = left+(right-left)/2;
        }
        return -1;
    }

    /**
     * 删除元素, 双指针
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int slowIndex= 0 ;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex]!=val){
                nums[slowIndex++]=nums[fastIndex];
            }
        }
        return slowIndex;
    }

    /**
     * 平方 双指针
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int right = nums.length-1;
        int left = 0;
        int k = nums.length-1;
        int[] result = new int[k];
        while (left<right){
            if(nums[right]*nums[right]>nums[left]*nums[left]){
                result[k--]=nums[right]*nums[right];
            }else {
                result[k--]=nums[left]*nums[left];
            }
        }
        return result;
    }

    /**
     * 滑动窗口，移动一步
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int start=0;
        int sum=0;
        int count=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            while (sum>=target){
                count=Math.min(count,i-start+1);
                sum-=nums[start++];
            }
        }
        return count;
    }

    /**
     * 螺旋矩阵
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int loop=0;
        int [][]res = new int[n][n];
        int start=0;
        int count=1;
        int i,j;
        while (loop++<n/2){
            for(j=start;j<n-loop;j++){
                res[start][j]=count++;
            }
            for (i =start ; i <n-loop ; i++) {
                res[i][j]=count++;
            }
            for (;j>=loop;j--){
                res[i][j]=count++;
            }
            for (;i>=loop;i--){
                res[i][j]=count++;
            }
            start++;
        }
        if(n%2==1){
            res[start][start]=count++;
        }
        return res;
    }
}
