package com.lyj.sc.leetcode.十月份;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-05 13:54
 **/
public class Main {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> counts= new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String cpdomain : cpdomains) {
            String[] s = cpdomain.split(" ");
            Integer count = Integer.parseInt(s[0]);
            counts.put(s[1],counts.getOrDefault(s[1],0)+count);
            for (int i = 0; i < s[1].length(); i++) {
                if(s[1].charAt(i)=='.'){
                    String subdomain = s[1].substring(i+1);
                    counts.put(subdomain,counts.getOrDefault(subdomain,0)+count);
                }
            }
        }
        for (String s1 : counts.keySet()) {
            String r = counts.get(s1)+" "+s1;
            res.add(r);
        }
        return res;
    }
}
