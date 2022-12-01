package com.lyj.sc.笔试.云账户;

import java.util.*;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-23 22:21
 **/
public class Main {
    public boolean isPalindrome (int x) {
        // write code here
        String str = String.valueOf(x);
        char[] c = str.toCharArray();
        int right = c.length-1;
        int left = 0 ;
        while (left<right){
            if(c[left]!=c[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int[] RightSideView (TreeNode root) {
        // write code here
        //层序遍历
        if(root==null){
            return new int[0];
        }
        // 存储值
        List<Integer> res  = new ArrayList<>();
        //  队列
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode treeNode = queue.peekLast();
            res.add(treeNode.val);
            for (int i = 0; i < size; i++) {
                treeNode = queue.pollFirst();
                if(treeNode.left!=null){
                    queue.offerLast(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.offerLast(treeNode.right);
                }
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i]=res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root.left=root2;
        root.right=root3;
        TreeNode root5 = new TreeNode(5);
        TreeNode root4 = new TreeNode(4);
        root2.right=root5;
        root3.right=root4;
        int[] ints = RightSideView(root);
        System.out.println(Arrays.toString(ints));
    }
}
