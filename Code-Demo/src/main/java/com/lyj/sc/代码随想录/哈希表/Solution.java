package com.lyj.sc.代码随想录.哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-01 17:30
 **/
public class Solution {

    public boolean isAnagram(String s, String t) {
        // 26字母
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            res[t.charAt(i)-'a']--;
        }
        for (int re : res) {
            if(re!=0){
                return false;
            }
        }
        return true;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1  =new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }

        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        return set2.stream().mapToInt(x->x).toArray();
    }

    public boolean isHappy(int n) {
        if(n==1){
            return true;
        }
        HashSet<Integer> set = new HashSet<>();
        while (n!=1){
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            n= caclute(n);
        }
        return true;
    }

    public int caclute(int n){
        int sum=0;
        while (n!=0){
            int i = n % 10;
            sum+=i*i;
            n=n/10;
        }
        return sum;
    }

    /**
     * 两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                res[0]=i;
                res[1]=map.get(target-nums[i]);
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}
