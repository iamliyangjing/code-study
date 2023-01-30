package com.lyj.sc.负载均衡.轮询;

import com.lyj.sc.负载均衡.ServerIps;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: Study-Demo
 * @description: 平均加权轮询
 * @author: lyj
 * @create: 2022-10-23 16:44
 **/
public class WeightRoundRobin {

    private static Map<String,Weight> WEIGHT = new ConcurrentHashMap<>();

    public static String getServer(){
        if (WEIGHT.isEmpty()){
            for (String ip : ServerIps.WEIGHT_MAP.keySet()) {
                Integer weight = ServerIps.WEIGHT_MAP.get(ip);
                WEIGHT.put(ip,new Weight(ip,weight,0));
            }
        }
        // 权重和 sum(weight)
        int total=0;
        for (Integer weight : ServerIps.WEIGHT_MAP.values()) {
            total+=weight;
        }
        // currentWeight += weight
        for (Weight weight : WEIGHT.values()) {
            weight.setCurrentWeight(weight.getCurrentWeight()+weight.getWeight());
        }

        // max(currentWeight)
        Weight maxCurrentWeight=null;
        for (Weight weight : WEIGHT.values()) {
            if(maxCurrentWeight ==null || weight.getCurrentWeight()>maxCurrentWeight.getCurrentWeight()){
                maxCurrentWeight=weight;
            }
        }
        // max(currentWeight) -= sum(weight)
        maxCurrentWeight.setCurrentWeight(maxCurrentWeight.getWeight()-total);
        // return
        return maxCurrentWeight.getIp();
    }
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(getServer());
        }
    }
}
