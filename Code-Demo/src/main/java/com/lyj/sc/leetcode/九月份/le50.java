package com.lyj.sc.leetcode.九月份;

import java.util.*;

/**
 * @program: code-random
 * @description:  https://leetcode.cn/problems/powx-n/
 * @author: lyj
 * @create: 2022-09-07 20:59
 **/
public class le50 {

    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        if(x==1){
            return x;
        }
        // n<0
        if(n<0){
            return myPow(1/x,-n);
        }else if(n%2==0){
            return myPow(x*x,n/2);
        }else {
            return myPow(x,n-1)*x;
        }
    }

    public int minOperations(String[] logs) {
        int len = logs.length;
        int count = 0;
        for(int i =0;i<len;i++){
            if(!logs[i].equals("../")){
                count++;
            }else{
                if(count>0){
                    count--;
                }
            }
        }
        return count;
    }

    public double trimMean(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        int c = (int) (len*0.05);
        double sum =  0;
        for (int i = c; i < (len - c); i++) {
            sum+=arr[i];
        }
        return sum/(len-2*c);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res =new ArrayList<>();
        int len = nums.length;
        for(int num:nums){
            num = (num-1)%len;
            nums[num]+=len;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<=len){
                res.add(i);
            }
        }
        return res;
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count=0;
        int current=0;
        for (int num : nums) {
            current+=num;
            if(map.containsKey(current-k)){
                count++;
            }
            map.put(current,map.getOrDefault(current,0)+1);
        }
        return count;
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String s = new String(array);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(str);
            map.put(s,list);
        }
        return new ArrayList<>(map.values());
    }


    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorder(root,list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i-1);
            TreeNode cur = list.get(i);
            pre.right=cur;
            pre.left=null;
        }
    }
    public void preorder(TreeNode node,List<TreeNode> list){
        if(node!=null){
            list.add(node);
            preorder(node.left,list);
            preorder(node.right,list);
        }
    }

}


