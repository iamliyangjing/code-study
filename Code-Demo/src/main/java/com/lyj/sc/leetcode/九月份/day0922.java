package com.lyj.sc.leetcode.九月份;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-09-22 10:37
 **/
public class day0922 {
    // 1640.能否连接形成数组
    // 哈希表
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length;
        int m = pieces.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(pieces[i][0],i);
        }
        for (int i = 0; i < n;) {
            if(!map.containsKey(arr[i])){
                return false;
            }
            Integer index = map.get(arr[i]);
            int l = pieces[index].length;
            for (int j = 0; j < l; j++) {
                if(arr[i+j]!=pieces[index][j]){
                    return false;
                }
            }
            i+=l;
        }
        return true;
    }


    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(4));
    }

    List<List<Integer>> edges;
    int[] visited;
    int[] stack;
    boolean isvalid=true;
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        visited=new int[numCourses];
        stack = new int[numCourses];
        index=numCourses-1;
        for (int[] pro : prerequisites) {
            edges.get(pro[1]).add(pro[0]);
        }

        for (int i = 0; i < numCourses && isvalid ; i++) {
            if(visited[i]==0){
                dfs(i);
            }
        }
        if(!isvalid){
            return new int[0];
        }
        return stack;
    }

    public void dfs(int u){
        visited[u]=1;
        for (int v : edges.get(u)) {
            if(visited[v]==0){
                dfs(v);
                if(!isvalid){
                    return;
                }
            }else if(visited[v]==1){
                isvalid=false;
                return;
            }
        }
        visited[u]=2;
        stack[index--]=u;
    }
}
