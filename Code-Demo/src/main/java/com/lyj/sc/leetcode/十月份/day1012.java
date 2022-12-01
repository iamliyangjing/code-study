package com.lyj.sc.leetcode.十月份;

import com.lyj.sc.leetcode.九月份.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-12 10:49
 **/
public class day1012 {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        boolean flag = false;
        while (head!=null){
            if(set.contains(head.val)){
                if(!flag){
                    flag=true;
                    res++;
                }
            } else {
                    flag=false;
                }
            head=head.next;
            }
        return res;
    }
}
