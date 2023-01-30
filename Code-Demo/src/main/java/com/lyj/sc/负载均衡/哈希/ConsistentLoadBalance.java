package com.lyj.sc.负载均衡.哈希;

import com.lyj.sc.负载均衡.ServerIps;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @program: Study-Demo
 * @description:
 * @author: lyj
 * @create: 2022-10-23 21:27
 **/
public class ConsistentLoadBalance {

    private static TreeMap<Integer,String> virtualNodes = new TreeMap<>();
    private static final int VIRTUAL_NODES = 160;

    static {
        for (String ip : ServerIps.LIST) {
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                int hash = getHash(ip+1);
                //放置虚拟节点
                virtualNodes.put(hash,ip);
            }
        }
    }

    private static String getServer(String client){
        int hash = getHash(client);

        //大于Hash，virtualNodes的子树的firstKey
        SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);

        Integer firstKey = null;
        //如果sumMap为null，证明大于此节点的子树为空，则从零开始
        if (subMap==null){
            firstKey = virtualNodes.firstKey();
        }else {
            firstKey  = subMap.firstKey();
        }
        return virtualNodes.get(firstKey);
    }


    private static int getHash(String str){
        final int p = 16777619;
        int hash =(int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) *p;
            hash+=hash<<13;
            hash^=hash>>7;
            hash+=hash<<3;
            hash^=hash>>17;
            hash+=hash<<5;
            //如果算出来的值为负数则取绝对值
            if (hash < 0){
                hash= Math.abs(hash);
            }
        }
        return hash;
    }

}
