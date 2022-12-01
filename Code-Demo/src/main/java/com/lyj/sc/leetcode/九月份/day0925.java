package com.lyj.sc.leetcode.九月份;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-25 10:11
 **/
public class day0925 {
    public int rotatedDigits(int n) {
        /*可以分类
            1. 0 1 8 不用管
            2. 2 5 6 9 是好数
            3. 3  4 7 不是 好数
         */
        int[] nums = {0,0,1,-1,-1,1,1,-1,0,1};
        int ans=0;
        for (int i = 1; i < n; i++) {
            String t = String.valueOf(i);
            boolean valid=true;
            boolean diff = false;
            for (int j = 0; j < t.length(); j++) {
                if(nums[t.charAt(i)-'0']==-1){
                    valid=false;
                }else if(nums[t.charAt(i)-'0']==1){
                    diff=true;
                }
            }
            if(valid&&diff){
                ans++;
            }
        }
        return ans;
    }

    List<List<Integer>> list;
    int[] stack;
    int[] visited;
    int index;
    boolean ans=true;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<Integer>());
        }
        stack=new int[numCourses];
        visited=new int[numCourses];
        index=numCourses-1;
        for (int i = 0; i < len; i++) {
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses && ans; i++) {
               if(visited[i]==0){
                   dfs(i);
               }
        }
        if(!ans){
            return new int[0];
        }
        return stack;
    }

    public void dfs(int u){
        // 标记为正在搜索
        visited[u]=1;
        for (int v : list.get(u)) {
            if(visited[v]==0){
                dfs(v);
            } else if (visited[v]==1) {
                ans=false;
                return;
            }
        }
        //比较为搜索完成
        visited[u]=2;
        stack[index--]=u;
    }

    /**
     * 课程表|| 图
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        list=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        visited=new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            list.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if(visited[i]==0){
                dfs1(i);
            }
        }
        return ans;
    }

    public void dfs1(int u){
        // 标记为正在搜索
        visited[u]=1;
        for (int v : list.get(u)) {
            if(visited[v]==0){
                dfs(v);
                if(!ans){
                    return;
                }
            } else if (visited[v]==1) {
                ans=false;
                return;
            }
        }
        //比较为搜索完成
        visited[u]=2;
    }

    public int leastInterval(char[] tasks, int n) {
        //1.频率
        // n = (maxfreq-1) * (n+1)+remains;
        int[] nums = new int[26];
        for (char task : tasks) {
            nums[task-'A']++;
        }
        //1. 找到最大频率
        int max = nums[0];
        for (int i = 0; i < 26; i++) {
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int res = (max-1)*(n+1);
        int count = 0;
        for (int num : nums) {
            if(num==max){
                count++;
            }
        }
        return res+count-1;
    }
}
