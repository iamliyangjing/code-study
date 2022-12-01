package com.lyj.sc.leetcode.九月份;

import java.util.*;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-09-17 00:22
 **/
public class day0917 {

    public int maxLengthBetweenEqualCharacters(String s) {
        int[] nums = new int[26];
        Arrays.fill(nums,-1);
        int maxLen = -1;
        for (int i = 0; i < s.length(); i++) {
            if(nums[s.charAt(i)-'a']<0){
                nums[s.charAt(i)-'a']=i;
            }else {
                maxLen=Math.max(maxLen,i-nums[s.charAt(i)-'a']-1);
            }
        }
        return maxLen;
    }

    public int maxArea(int[] height) {
        //双指正
        int i = height.length-1;
        int j = 0;
        int res = -1;
        while(j<i){
            if(height[i]>height[j]){
                j++;
            }else{
                i--;
            }
            res = Math.max(res,Math.min(height[i],height[j])*(i-j+1));
        }
        return res;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        int left = binarySerach(nums,target,true);
        int right = binarySerach(nums,target,false)-1;
        if(right<=nums.length && left<=nums.length && nums[left]==target && nums[right]==target){
            res[0]=left;
            res[1]=right;
        }
        return res;
    }

    public int binarySerach(int[] nums,int target,boolean lower){
        int left=0;
        int right=nums.length-1;
        int ans = nums.length;
        while(left<=right){
            int mid = (left+right)>>>1;
            if(nums[mid]>target ||(lower && nums[mid]>=target)){
                right=mid-1;
                ans=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    public int maxProduct(int[] nums) {
        //最大值 最小值 动态规划
        int ans=nums[0],MaxF=nums[0],MinF=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            int mx=MaxF,mn=MinF;
            MaxF=Math.max(mx*nums[i],Math.max(nums[i],mn*nums[i]));
            MinF=Math.min(mn*nums[i],Math.min(nums[i],mx*nums[i]));
            ans=Math.max(ans,MaxF);
        }
        return ans;
    }
//
public List<Integer> findAnagrams(String s, String p) {
    //滑动窗口
    int slen = s.length();
    int plen = p.length();
    if(plen>slen){
        return new ArrayList<>();
    }
    int[] numsp = new int[26];
    int[] nums = new int[26];
    for(int i = 0;i<plen;i++){
        nums[s.charAt(i)-'a']++;
        numsp[p.charAt(i)-'a']++;
    }
    List<Integer> list = new ArrayList<>();
    if (Arrays.equals(nums,numsp)) {
        list.add(0);
    }
    for (int i = 0; i < (slen - plen); i++) {
        nums[s.charAt(i)-'a']--;
        nums[s.charAt(i+plen)-'a']++;
        if (Arrays.equals(nums,numsp)) {
            list.add(i+1);
        }
    }
    return list;
    }


    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int n:nums){
            list.add(n);
        }
        Collections.sort(list,(a,b)->{
            int c1=map.get(a);
            int c2 =map.get(b);
            return c1!=c2?c1-c2:b-a;
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i]=list.get(i);
        }
        return nums;
    }

    public int majorityElement(int[] nums) {
        int n = nums.length;
        int c = n/2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int n1:nums){
            map.put(n1,map.getOrDefault(n1,0)+1);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if(integerIntegerEntry.getValue()>3){
                return integerIntegerEntry.getKey();
            }
        }
        return -1;
    }
}
