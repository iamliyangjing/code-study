package com.lyj.sc.代码随想录.二叉树.遍历.迭代法;


import com.lyj.sc.leetcode.九月份.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-04 23:58
 **/
public class Solution {
//    public List<Integer> postorderTraversal(TreeNode root) {
//        Deque<TreeNode> stack = new LinkedList<>();
//        List<Integer> res = new ArrayList<>();
//        //左右中
//        if (root==null){
//            return res;
//        }
//        stack.push(root);
//        while (!stack.isEmpty()){
//            TreeNode temp = stack.pop();
//            res.add(temp.);
//
//        }
//    }
public List<List<Integer>> levelOrder(TreeNode root) {
    Deque<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    if(root==null){
        return  res;
    }
    queue.offer(root);
    while (!queue.isEmpty()){
        int len = queue.size();
        List<Integer> temp = new ArrayList<>();
        while (len-->0){
            TreeNode t = queue.poll();
            temp.add(t.val);
            if(t.left!=null)
                queue.offer(t.left);
            if(t.right!=null)
                queue.offer(t.right);
        }
        res.add(temp);
    }
    return res;
}
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res =  new ArrayList<>();
        if(root==null){
            return res;
        }
        List<Integer> paths=new ArrayList<>();
        traversal(root,res,paths);
        return res;
    }
    // 回溯
    private void traversal(TreeNode root,List<String> res,List<Integer> list){
        list.add(root.val);
        if(root.left==null && root.right==null){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size()-1; i++) {
                sb.append(list.get(i)).append("->");
            }
            sb.append(list.get(list.size()-1));
            res.add(sb.toString());
            //结束
            return;
        }
        if(root.left!=null){
            traversal(root.left,res,list);
            list.remove(list.size()-1);
        }
        if(root.right!=null){
            traversal(root.right,res,list);
            list.remove(list.size()-1);
        }
    }

}
