package com.lyj.sc.CodeTop;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-25 23:43
 **/
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0,new ArrayList<>());
        return res;
    }

    void backtracking(int[] nums,int start,List<Integer> list){
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(nums,i+1,list);
            list.remove(list.size()-1);
        }
    }

}
