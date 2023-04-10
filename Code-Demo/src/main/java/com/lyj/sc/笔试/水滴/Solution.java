package com.lyj.sc.笔试.水滴;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @program: code-study
 * @description:
 * @author: lyj
 * @create: 2023-03-23 22:08r
 **/
public class Solution {

    public int countSubStr (String s) {
        // write code here
        char[] str = s.toCharArray();
        int l = str.length;
        if(l==1){
            return 1;
        }
        Set<Character> set = new HashSet<>();
        TreeMap<Character,Integer> map = new TreeMap<>();
        int count = 0;
        for (int i = 0; i < l; i++) {
            set.clear();
            set.add(str[i]);
            map.clear();
            map.put(str[i],1);
            for (int j = i+1; j <l ; j++) {
                set.add(str[j]);
                map.put(str[j],map.getOrDefault(str[j],0)+1);
                System.out.println("key:"+map.lastEntry().getKey()+"value:"+map.lastEntry().getValue());
                if(map.get(map.lastKey())<set.size()){
                  count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubStr("2023"));
    }
}
