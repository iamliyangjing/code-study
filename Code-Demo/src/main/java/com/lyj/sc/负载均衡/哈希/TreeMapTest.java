package com.lyj.sc.负载均衡.哈希;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2023-01-12 14:13
 **/
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap<>();

        treeMap.put("1","1");
        treeMap.put("2","2");
        treeMap.put("3","3");
        treeMap.put("4","4");
        treeMap.put("5","5");
        // 有序  第一个key 是最小的key
        System.out.println(treeMap.firstKey());
        // 返回大于等于4的树
        SortedMap sortedMap = treeMap.tailMap("4");
        System.out.println(sortedMap.firstKey());
    }
}
