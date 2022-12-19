package com.lyj.sc.代码随想录.二叉树;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2022-12-04 23:58
 **/
 public class TreeNode {
      int val;
       public TreeNode left;
      public TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
         this.right = right;
     }
 }
