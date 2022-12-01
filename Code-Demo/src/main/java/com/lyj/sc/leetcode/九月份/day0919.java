package com.lyj.sc.leetcode.九月份;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: code-random
 * @description:
 * @author: lyj
 * @create: 2022-09-19 10:17
 **/
public class day0919 {

    public int pathSum(TreeNode root, int targetSum) {
        //DFS
        Map<Long,Integer> prex = new HashMap<>();
        prex.put(0L,1);
        return dfs(root,targetSum,prex,0);
    }
    public int dfs(TreeNode root,int targetSum,Map<Long,Integer> prex,long cur){
        if(root==null){
            return 0;
        }
        int ret = 0;
        //加值
        cur+=root.val;
        //相等
        ret = prex.getOrDefault(cur-targetSum,0);
        prex.put(cur,prex.getOrDefault(cur,0)+1);
        ret+=dfs(root.left,targetSum,prex,cur);
        ret+=dfs(root.right,targetSum,prex,cur);
        prex.put(cur,prex.getOrDefault(cur,1)-1);
        return ret;
    }
}
