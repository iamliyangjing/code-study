package com.lyj.sc.leetcode.十月份;

import java.util.Arrays;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-08 23:30
 **/
public class day1008 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx1 = new Integer[n];
        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx1[i]=i;
            idx2[i]=n;
        }
        Arrays.sort(idx1,(i,j)->nums1[i]-nums1[j]);
        Arrays.sort(idx1,(i,j)->nums2[i]-nums2[j]);

        int[] ans = new int[n];
        int left=0,right=n-1;
        for (int i = 0; i < n; i++) {
            if(nums1[idx1[i]]>nums2[idx2[left]]){
                ans[idx2[left]]=nums1[idx1[i]];
                ++left;
            }else {
                ans[idx2[right]]=nums1[idx1[i]];
                --right;
            }
        }
        return ans;
    }


    public String multiply(String num1, String num2) {
        int m =num1.length();
        int n= num2.length();
        int[]arr = new int[m+n];
        for (int i = m-1; i >=0; i--) {
            int a1 = num1.charAt(i)-'0';
            for (int j = (n-1); j > 0; j--) {
                int a2=num2.charAt(j)-'0';
                arr[i+j+1]+=a1*a2;
            }
        }
        for (int i = (m + n - 1); i > 0; i--) {
            arr[i-1]+=arr[i]/10;
            arr[i]%=10;
        }
        int index = arr[0]==0?1:0;
        StringBuilder sb = new StringBuilder();
        while (index<m+n){
            sb.append(index);
            index++;
        }
        return sb.toString();
    }
}
